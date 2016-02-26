package Objects;

//Cantr Log Converter by re4der, version 1.6

import localizations.Localization;
import localizations.Polish;


public class Converter {
    
    private final String endl = "\n";
    
    //settings
    String name;
    
    private final boolean reverseLog;
    private final boolean removeNoSpeech;
    private final boolean removeRolePlay;
    
    private final boolean action;
    private final boolean data;
    private final boolean label;
    private final boolean quotation;
    
    private final boolean radio;
    private final boolean frequency;
    private final boolean fixedQuotings;
    
    private Localization lang;
    private boolean isFPS;
    
    public Converter(boolean log, boolean action, boolean noSpeech, boolean data, boolean label, boolean rolePlay, boolean quotation, boolean radio, boolean frequency, boolean fixedQuotings){
	this.reverseLog = log;
	this.action = action;
	this.removeNoSpeech = noSpeech;
	this.data = data;
	this.label = label;
	this.removeRolePlay = rolePlay;
	this.quotation = quotation;
	this.radio = radio;
	this.frequency = frequency;
	this.fixedQuotings = fixedQuotings;
    }
    
    public void setLanguage(Localization loc){
	this.lang = loc;
	this.name = loc.characterName;
    }
    public void setPerspective(boolean isFPS){
	this.isFPS = isFPS;
    }
    
    public String convert(String toConvert){
	//init and stuff
	String convertedText = new String("");
	String[] splitText = toConvert.split("\\r?\\n");
	LogLine[] log = new LogLine[splitText.length];
	
	//extract name
	String firstChar = "";
	firstChar += splitText[splitText.length-1].charAt(0);

	String secondChar = "";
	secondChar += splitText[splitText.length-1].charAt(splitText[splitText.length-1].length()-1);
	
	if(firstChar.equals("*") && secondChar.equals("*")){
	    name = splitText[splitText.length-1].substring(1, splitText[splitText.length-1].length()-1);
	    splitText[splitText.length-1] = "";
	}
	
	//shuffle
	for(int count = 0; count<splitText.length; count++){
	    ////disassemble
	    //create log
	    log[count] = new LogLine();

	    //get data
	    String cache = splitText[count];
	    String[] cacheArray = cache.split("-", 2);
	    log[count].day = cacheArray[0];
	    try{
		cache = cacheArray[1];
	    } catch(ArrayIndexOutOfBoundsException argh){
		continue;
	    }
	    cacheArray = null;

	    log[count].hour = String.valueOf(cache.charAt(0));
	    boolean getMinute = true;
	    if(cache.charAt(1)!='.'){
		getMinute = false;
	    }
	    cache = cache.substring(2);

	    if(getMinute){
		log[count].minute = String.valueOf(cache.substring(0, 2));
		cache = cache.substring(4);
	    }

	    //get label
	    cacheArray = null;
	    cacheArray = cache.split(":", 2);
	    
	    //remove needless space from label
	    if(String.valueOf(cacheArray[0].charAt(0)).equals(" ")){
		cacheArray[0] = cacheArray[0].substring(1);
	    }
	    
	    //FPS
	    if(isFPS){
		if(cacheArray[0].startsWith(lang.fromRadio)){
		    if(radio){
			log[count].frequency = cacheArray[0].substring(cacheArray[0].length()-3, cacheArray[0].length());
			if(frequency){
			    log[count].label = lang.radio+"["+log[count].frequency+"]";
			}
			else{
			    log[count].label = lang.radio;
			}
		    }
		    else{
			continue;
		    }
		}
		else{
		    log[count].label = cacheArray[0];
		}
	    }
	    //TPS
	    else if(!isFPS){
		if(cacheArray[0].endsWith(lang.someoneSays)){
		    log[count].label = cacheArray[0];
		}
		else if(cacheArray[0].startsWith(lang.youSayTo)){
		    log[count].label = cacheArray[0].replaceFirst(lang.youSayTo, name+lang.saysTo)+".";
		    cacheArray[1] = "";
		}
		else if(cacheArray[0].endsWith(lang.playerSays)){
		    log[count].label = name+lang.someoneSays;
		}
		else if(cacheArray[0].startsWith(lang.fromRadio)){
		    if(radio){
			log[count].frequency = cacheArray[0].substring(cacheArray[0].length()-3, cacheArray[0].length());
			if(frequency){
			    log[count].label = lang.radio+"["+log[count].frequency+"]";
			}
			else{
			    log[count].label = lang.radio;
			}
		    }
		    else{
			continue;
		    }
		}
		else if(cacheArray[0].startsWith(lang.youSee)){
		    log[count].label = cacheArray[0];
		    log[count].label = log[count].label.replaceFirst(lang.youSee, "");
		    log[count].label = replaceSkillAdverb(log[count].label);
		}
		else if(cacheArray[0].startsWith(lang.newPerson)){
		    log[count].label = cacheArray[0];
		    log[count].label = lang.appears+log[count].label.replaceFirst(lang.newPerson, "");
		    if(lang instanceof Polish){
			log[count].label = log[count].label.replaceAll("której jeszcze nie widziałeś - to ", "");
			log[count].label = log[count].label.replaceAll("której jeszcze nie widziałaś - to ", "");
		    }
		}
		else if(cacheArray[0].startsWith(lang.youSeeThatItem)){
		    log[count].label = cacheArray[0];
		    log[count].label = String.valueOf(log[count].label.replaceFirst(lang.youSeeThatItem, "").charAt(0)).toUpperCase()+log[count].label.replaceFirst(lang.youSeeThatItem, "").substring(1);
		}
		else if(cacheArray[0].startsWith(lang.youSeeThatPerson)){
		    log[count].label = cacheArray[0];
		    log[count].label = String.valueOf(log[count].label.replaceFirst(lang.youSeeThatPerson, "").charAt(0)).toUpperCase()+log[count].label.replaceFirst(lang.youSeeThatPerson, "").substring(1);
		}
		else if(cacheArray[0].contains(lang.someonePlays)){
		    log[count].label = cacheArray[0];
		}
		else if(cacheArray[0].startsWith(lang.youPlay)){
		    log[count].label = name+cacheArray[0].replaceFirst(lang.youPlay, lang.someonePlays);
		}
		else if(cacheArray[0].startsWith(lang.youAttack)){
		    if(lang instanceof Polish){
			log[count].label = name+cacheArray[0].replaceFirst(lang.youAttack, lang.someoneAttacks).replace(lang.youMiss, lang.someoneMisses);
			log[count].label = replaceSkillAdverb(log[count].label);
		    }
		}
		else if(cacheArray[0].contains(lang.attacksYou)){
		    log[count].label = cacheArray[0].replaceFirst(lang.attacksYou, lang.someoneAttacks+name+" ").replaceAll(lang.doesNotWoundYou, "");
		    log[count].label = replaceSkillAdverb(log[count].label);
		}
		else if(cacheArray[0].startsWith(lang.youEnterFrom)){
		    String placeholder = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.whereYouSee));
		    log[count].label = name+lang.someoneEntersFrom+placeholder.replace(lang.youEnterFrom, "")+".";
		}
		else if(cacheArray[0].startsWith(lang.youEnter)){
		    String placeholder = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.youEnterAndSee));
		    log[count].label = name+lang.someoneEnters+placeholder.replace(lang.youEnter, "")+".";
		}
		else if(cacheArray[0].startsWith(lang.someoneDraggedYou)){
		    String placeholder = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.youSeeHere));
		    log[count].label = placeholder.replace(lang.you, " "+name+" ");
		}
		else if(cacheArray[0].startsWith(lang.usingBeg) && cacheArray[0].contains(lang.youHurt)){
		    String usedWeapon = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.youHurt));
		    usedWeapon = replaceSkillAdverb(usedWeapon);
		    usedWeapon = usedWeapon.replace(lang.usingBeg, "");
		    
		    cacheArray[0] = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.suchThat));
		    log[count].label = name+lang.someoneHurts+cacheArray[0].replace(lang.usingBeg, "").replace(lang.youHurt, "");
		    log[count].label = replaceSkillAdverb(log[count].label).replace(usedWeapon, "")+lang.usingMid+usedWeapon;
		    log[count].label = log[count].label.substring(0, log[count].label.length()-1)+".";
		}
		else if(cacheArray[0].contains(lang.someoneHurts) && cacheArray[0].contains(lang.you)){
		    log[count].label = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.youLose));
		    log[count].label = replaceSkillAdverb(log[count].label);
		    log[count].label = log[count].label.replace(lang.you, " "+name+" ");
		}
		else if(cacheArray[0].startsWith(lang.youHearThat)){
		    log[count].label = String.valueOf(cacheArray[0].replaceFirst(lang.youHearThat, "").charAt(0)).toUpperCase()+cacheArray[0].replaceFirst(lang.youHearThat, "").substring(1, cacheArray[0].replaceFirst(lang.youHearThat, "").length())+".";
		    cacheArray[1] = "";
		}
		else if(cacheArray[0].startsWith(lang.someonePulledYou)){
		    log[count].label = cacheArray[0].replace(lang.you, " "+name+" ");
		    log[count].label = log[count].label.substring(0, log[count].label.lastIndexOf(lang.youSeeHere));
		}
		else if(cacheArray[0].startsWith(lang.youHearAs)){
		    log[count].label = cacheArray[0].replace(lang.youHearAs, "");
		    log[count].label = String.valueOf(log[count].label.charAt(0)).toUpperCase()+log[count].label.substring(1, log[count].label.length());
		}
		else if(cacheArray[0].startsWith(lang.youKnock)){
		    log[count].label = cacheArray[0].replace(lang.youKnock, lang.someoneKnocks);
		}
		else if(cacheArray[0].startsWith(lang.youHurtAnimal)){
		    log[count].label = replaceSkillAdverb(cacheArray[0]).replace(lang.youHurtAnimal, name+lang.someoneHurts).replace(lang.youTwo, " ").replace(lang.withHelpOf, ","+lang.usingMid);
		    log[count].label = log[count].label.substring(0, log[count].label.lastIndexOf(lang.animalLoses));
		}
		else if(cacheArray[0].startsWith(lang.usingBeg)){
		    log[count].label = replaceSkillAdverb(cacheArray[0]);
		    
		    String animal = log[count].label.substring(log[count].label.lastIndexOf(lang.youKill)+lang.youKill.length(), log[count].label.length()-1);
		    String usedWeapon = log[count].label.replace(lang.usingBeg, "").substring(0, log[count].label.lastIndexOf(lang.youKill)-lang.youKill.length());
		    
		    log[count].label = name+lang.someoneKills+animal+lang.usingMid+usedWeapon+".";
		}
		else if(cacheArray[0].startsWith(lang.youPayAttentionTo)){
		    log[count].label = cacheArray[0].replace(lang.youPayAttentionTo, lang.canBeSeen);
		}
		else if(cacheArray[0].startsWith(lang.attacksYouAnimal)){
		    log[count].label = cacheArray[0].replace(lang.attacksYouAnimal, lang.canBeSeen).substring(0, cacheArray[0].replace(lang.attacksYouAnimal, lang.canBeSeen).lastIndexOf(lang.youLose)-1)+lang.thatAnimalAttacks+name+".";
		}
		else if(cacheArray[0].startsWith(lang.youCares)){
		    log[count].label = cacheArray[0].replace(lang.youCares, name+lang.someoneCarreses);
		}
		else if(cacheArray[0].startsWith(lang.youPoint)){
		    log[count].label = cacheArray[0].replace(lang.youPoint, name+lang.someonePoints);
		}
		else if(cacheArray[0].startsWith(lang.youPass)){
		    if((cacheArray[0].contains(lang.amount) || cacheArray[0].contains(lang.some))){
			String item = cacheArray[0].substring(0, cacheArray[0].lastIndexOf(lang.to));
			item = item.replace(lang.youPass, "");
			item = lang.some+item.substring(item.lastIndexOf(lang.amount)+lang.amount.length(), item.length());

			String whom = cacheArray[0].substring(cacheArray[0].lastIndexOf(lang.to));
			whom = whom.substring(1, whom.length()-1);

			log[count].label = name+lang.passes+whom+item+".";
		    }
		    else{
			String item = cacheArray[0].replace(lang.youPass, "").substring(0, cacheArray[0].replace(lang.youPass, "").lastIndexOf(lang.to));
			
			String whom = cacheArray[0].substring(cacheArray[0].lastIndexOf(lang.to), cacheArray[0].length()-1);
			
			log[count].label = name+lang.passes+whom.substring(1)+lang.somethingLookingLike+item+".";
		    }
		}
		else if(cacheArray[0].contains(lang.gives+lang.toYou.substring(1))){
		    if((cacheArray[0].contains(lang.amount) || cacheArray[0].contains(lang.some))){
			String cach = lang.gives+lang.toYou.substring(1);
			String item = cacheArray[0].substring(cacheArray[0].lastIndexOf(cach.substring(1))+cach.length()-1, cacheArray[0].length());
			cach = lang.some+item.substring(item.lastIndexOf(lang.amount)+lang.amount.length(), item.length());

			log[count].label = cacheArray[0].replace(lang.gives, lang.passes+lang.to.substring(1)+" ").replace(lang.toYou, name).replace(item, cach);
		    }
		    else{
			log[count].label = cacheArray[0].replace(lang.gives, lang.passes+lang.to.substring(1)+" ").replace(lang.toYou, name+lang.somethingLookingLike);
		    }
		}
		else if(cacheArray[0].startsWith(lang.youPoke)){
		    log[count].label = name+cacheArray[0].replace(lang.youPoke, lang.someonePokes);
		}
		else if(cacheArray[0].startsWith(lang.youRoll)){
		    log[count].label = name+cacheArray[0].replace(lang.youRoll, lang.someoneRolls);
		}
		else if(cacheArray[0].startsWith(lang.youTake)){
		    if(cacheArray[0].contains(lang.amount)){
			log[count].label = name+lang.someoneTakes+lang.some.substring(1)+cacheArray[0].substring(cacheArray[0].lastIndexOf(lang.amount)+lang.amount.length());
		    }
		    else{
			log[count].label = name+lang.someoneTakes+cacheArray[0].replace(lang.youTake, "");
		    }
		}
	    }

	    //get text and remove roleplay
	    if(cacheArray.length>1){
		log[count].text = cacheArray[1];
	    }
	    
	    String rewrite = "";
	    cache = null;
	    if(removeRolePlay){
		boolean erase = false;
		rewrite = "";
		for(int countIn = 0; countIn<log[count].text.length(); countIn++){
		    if(erase){
			if(!erase){
			    rewrite+=(char)log[count].text.codePointAt(countIn);
			}
			if(log[count].text.charAt(countIn)==lang.rolePlayLetter){
			    erase = !erase;
			}
		    }
		    else{
			if(log[count].text.charAt(countIn)==lang.rolePlayLetter){
			    erase = !erase;
			}
			if(!erase){
			    rewrite+=(char)log[count].text.codePointAt(countIn);
			}
		    }
		}
		cache = rewrite.replaceAll(" ", "");
	    }
	    //remove remains
	    if(cache!=null){
		if(cache.length()<3){
		    if(log[count].label.endsWith(lang.someoneSays) || log[count].label.endsWith(lang.playerSays)){
			continue;
		    }
		    else{
			log[count].text = rewrite;
		    }
		}
		else{
		    log[count].text = rewrite;
		}
	    }
	    //quoting
	    if(!quotation){
		if(log[count].text.endsWith("`.")){
		    log[count].text = log[count].text.substring(2, log[count].text.length()-2);
		}
		else if(log[count].text.endsWith("\"") && log[count].text.startsWith(" \"")){
		    log[count].text = log[count].text.substring(2, log[count].text.length()-1);
		}
	    }
	    //fix quotings
	    else{
		if(log[count].text.endsWith("`.")){
		    log[count].text = log[count].text.substring(0, log[count].text.length()-1);
		    if(fixedQuotings){
			log[count].text = log[count].text.substring(2, log[count].text.length()-1);
			log[count].text = "\""+log[count].text+"\"";
		    }
		}
	    }

	    ////assemble
	    cache = "";

	    //add data
	    if(data){
		if(log[count].day!=null){
		    cache+=log[count].day;
		}
		if(log[count].hour!=null){
		    cache+="-"+log[count].hour;
		}
		if(log[count].minute!=null){
		    cache+="."+log[count].minute;
		}
		cache+=": ";
	    }

	    //add label
	    if(label){
		if(log[count].text.length()>0){
		    cache+=log[count].label+": ";
		    if(!action){
			cache = cache.replace(lang.someoneSays, "");
		    }
		}
		else{
		    cache+=log[count].label;
		}
	    }

	    //add text
	    cache+=log[count].text;

	    //remove other
	    if(removeNoSpeech){
		if(log[count].label.endsWith(lang.someoneSays)){
		    convertedText+=cache+endl;
		}
		else if(log[count].label.startsWith(lang.radio) && radio){
		    convertedText+=cache+endl;
		}
	    }
	    else{
		convertedText+=cache+endl;
	    }
	}

	//reverse
	String finalText = "";
	if(reverseLog){
	    splitText = convertedText.split("\\r?\\n");
	    for(int count = 0; count<splitText.length; count++){
		finalText+=splitText[splitText.length-1-count]+endl;
	    }
	}
	else{
	    finalText = convertedText;
	}
	
	return finalText;
    }
    
    private String replaceSkillAdverb(String str){
	String cache = str;
	cache = cache.replace(lang.master, "");
	cache = cache.replace(lang.skilled, "");
	cache = cache.replace(lang.average, "");
	cache = cache.replace(lang.novice, "");
	cache = cache.replace(lang.bad, "");
	
	return cache;
    }
}
