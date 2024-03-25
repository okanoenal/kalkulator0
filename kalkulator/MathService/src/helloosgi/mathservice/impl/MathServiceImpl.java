package helloosgi.mathservice.impl;

import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.lang.String;
import java.lang.Math; 
import helloosgi.mathservice.MathService;

public class MathServiceImpl implements MathService {

   @Override
   	
   	public String locale() {
	   return "Turkish";} // Burada Turkish yerine English return ederek uygulamanın ingilizce versiyonuna erişebilirsiniz.
   
   
   	public long WordToNum(String userinput) {
   		
   		boolean ValidInput = true;
   		long result = 0;
   		long fresult = 0;
   		boolean neg = false;
   		List<String> allowedStrings_en = Arrays.asList(
   				
   		"zero","one","two","three","four","five","six","seven","eight","nine",
   		"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen",
   		"eighteen","nineteen","twenty","thirty","fourty","fifty","sixty","seventy","eighty",
   		"ninety","hundred","thousand","million","billion","trillion","minus"		
   		);
   		
   		List<String> allowedStrings_tr = Arrays.asList(
   				
   				"sıfır","bir","iki","üç","dört","beş","altı","yedi",
	    	    "sekiz","dokuz","on","yirmi","otuz","kırk",
	    	    "elli","altmış","yetmiş","seksen","doksan","yüz",
	    	    "bin","milyon","milyar","trilyon","eksi"		
   		   		);
   		
   		//String userinput = "One hundred thousand and five hundred and fifty five";
   		if (userinput != null && userinput.length()>0) {
   			
   			userinput = userinput.replaceAll("-"," ");
   			userinput = userinput.toLowerCase().replaceAll(" and", " ");
   			String[] splittedNum = userinput.trim().split("\\s+");
   			
   			for(String str : splittedNum){
   				if (locale()=="English") {
   					if(!allowedStrings_en.contains(str)) {
   						ValidInput = false;
   						System.out.println("Invalid word!! :" + str);
   						break;
   				}}
   				else if(locale()=="Turkish"){
   					if(!allowedStrings_tr.contains(str)) {
   						ValidInput = false;
   						System.out.println("Geçersiz kelime!! :" + str);
   						break;
   				}}
   			}
   			if(ValidInput) {
   				if(locale()=="English"){
   				for(String str : splittedNum) {
   					if (str.equalsIgnoreCase("minus")){neg = true;}
   					else if(str.equalsIgnoreCase("zero")) {result += 0;}
   					else if(str.equalsIgnoreCase("one")) {result += 1;}
   					else if(str.equalsIgnoreCase("two")) {result += 2;}
   					else if(str.equalsIgnoreCase("three")) {result += 3;}
   					else if(str.equalsIgnoreCase("four")) {result += 4;}
   					else if(str.equalsIgnoreCase("five")) {result += 5;}
   					else if(str.equalsIgnoreCase("six")) {result += 6;}
   					else if(str.equalsIgnoreCase("seven")) {result += 7;}
   					else if(str.equalsIgnoreCase("eight")) {result += 8;}
   					else if(str.equalsIgnoreCase("nine")) {result += 9;}
   					else if(str.equalsIgnoreCase("ten")) {result += 10;}
   					else if(str.equalsIgnoreCase("eleven")) {result += 11;}
   					else if(str.equalsIgnoreCase("twelve")) {result += 12;}
   					else if(str.equalsIgnoreCase("thirteen")) {result += 13;}
   					else if(str.equalsIgnoreCase("fourteen")) {result += 14;}
   					else if(str.equalsIgnoreCase("fiveteen")) {result += 15;}
   					else if(str.equalsIgnoreCase("sixteen")) {result += 16;}
   					else if(str.equalsIgnoreCase("seventeen")) {result += 17;}
   					else if(str.equalsIgnoreCase("eighteen")) {result += 18;}
   					else if(str.equalsIgnoreCase("nineteen")) {result += 19;}
   					else if(str.equalsIgnoreCase("twenty")) {result += 20;}
   					else if(str.equalsIgnoreCase("thirty")) {result += 30;}
   					else if(str.equalsIgnoreCase("fourty")) {result += 40;}
   					else if(str.equalsIgnoreCase("fifty")) {result += 50;}
   					else if(str.equalsIgnoreCase("sixty")) {result += 60;}
   					else if(str.equalsIgnoreCase("seventy")) {result += 70;}
   					else if(str.equalsIgnoreCase("eighty")) {result += 80;}
   					else if(str.equalsIgnoreCase("ninety")) {result += 90;}
   					else if(str.equalsIgnoreCase("hundred")) {result *= 100;}
   					else if(str.equalsIgnoreCase("thousand")) {result *= 1000;
   					                                           fresult += result;			
                       result = 0;
   					}
   					else if(str.equalsIgnoreCase("million")) {result *= 1000000;
   					                                          fresult += result;			
                                                                 result = 0;
                       }
   					else if(str.equalsIgnoreCase("billion")) {result *= 1000000000;
   					                                          fresult += result;			
                                                                 result = 0; 
   					}
   					else if(str.equalsIgnoreCase("trillion")) {result *= 1000000000000L;
   															   fresult += result;			
   					                                           result = 0;
   					}	
   				}
   				fresult += result;
   				if(neg ==true){fresult = 0 - fresult;}
   				result = 0;
   				return fresult;
   				}
   				
   				else if(locale()=="Turkish") {
   					for(String str : splittedNum) {
   						if (str.equalsIgnoreCase("eksi")){neg = true;}
   						else if(str.equalsIgnoreCase("sıfır")) {result += 0;}
   	   					else if(str.equalsIgnoreCase("bir")) {result += 1;}
   	   					else if(str.equalsIgnoreCase("iki")) {result += 2;}
   	   					else if(str.equalsIgnoreCase("üç")) {result += 3;}
   	   					else if(str.equalsIgnoreCase("dört")) {result += 4;}
   	   					else if(str.equalsIgnoreCase("beş")) {result += 5;}
   	   					else if(str.equalsIgnoreCase("altı")) {result += 6;}
   	   					else if(str.equalsIgnoreCase("yedi")) {result += 7;}
   	   					else if(str.equalsIgnoreCase("sekiz")) {result += 8;}
   	   					else if(str.equalsIgnoreCase("dokuz")) {result += 9;}
   	   					else if(str.equalsIgnoreCase("on")) {result += 10;}
   	   					else if(str.equalsIgnoreCase("on bir")) {result += 11;}
   	   					else if(str.equalsIgnoreCase("on iki")) {result += 12;}
   	   					else if(str.equalsIgnoreCase("on üç")) {result += 13;}
   	   					else if(str.equalsIgnoreCase("on dört")) {result += 14;}
   	   					else if(str.equalsIgnoreCase("on beş")) {result += 15;}
   	   					else if(str.equalsIgnoreCase("on altı")) {result += 16;}
   	   					else if(str.equalsIgnoreCase("on yedi")) {result += 17;}
   	   					else if(str.equalsIgnoreCase("on sekiz")) {result += 18;}
   	   					else if(str.equalsIgnoreCase("on dokuz")) {result += 19;}
   	   					else if(str.equalsIgnoreCase("yirmi")) {result += 20;}
   	   					else if(str.equalsIgnoreCase("otuz")) {result += 30;}
   	   					else if(str.equalsIgnoreCase("kırk")) {result += 40;}
   	   					else if(str.equalsIgnoreCase("elli")) {result += 50;}
   	   					else if(str.equalsIgnoreCase("altmış")) {result += 60;}
   	   					else if(str.equalsIgnoreCase("yetmiş")) {result += 70;}
   	   					else if(str.equalsIgnoreCase("seksen")) {result += 80;}
   	   					else if(str.equalsIgnoreCase("doksan")) {result += 90;}
   	   					else if(str.equalsIgnoreCase("yüz")) {if(result==0)
   	   															result=1;
   	   														  result *= 100;}
   	   					else if(str.equalsIgnoreCase("bin")) {if(result==0)
									   	                		result=1;
									   	   					result *= 1000;
   	   					                                    fresult += result;			
   	   					                                    result = 0;
   	   					}
   	   					else if(str.equalsIgnoreCase("milyon")) {result *= 1000000;
   	   					                                          fresult += result;			
   	                                                                 result = 0;
   	                       }
   	   					else if(str.equalsIgnoreCase("milyar")) {result *= 1000000000;
   	   					                                          fresult += result;			
   	                                                                 result = 0; 
   	   					}
   	   					else if(str.equalsIgnoreCase("trilyon")) {result *= 1000000000000L;
   	   															   fresult += result;			
   	   					                                           result = 0;
   	   					}	
   	   				}
   	   				fresult += result;
   	   				if(neg ==true){fresult = 0 - fresult;}
   	   				result = 0;
   	   				return fresult;
   					
   				}
   			}
   			
   		}
   				
   				
   		
   		return 0;
   		
   	}

   	
   	
   	public String NumToWord(long numy) {
   		String[] tens = {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
   		String[] digits = {"","one","two","three","four","five","six","seven","eight","nine"};
   		String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
   		
   		String[] birler = { "", "bir", "iki", "üç", "dört","beş", "altı", "yedi", "sekiz", "dokuz"};
   		String[] onlar = { "","on","yirmi","otuz","kırk","elli","altmış","yetmiş","seksen","doksan"};
   		
   		
   		
   		
   		int fd = (int) numy%10;
   		int fdd = (int) numy/10;
   		int sd = (int) fdd%10;
   		int sdd = (int) numy/100;
   		int td = (int) sdd%10;
   		int tdd = (int) numy/1000;
   		int fthd = (int) tdd%10;
   		int fthdd = (int) numy/10000;
   		int fifthd = (int) fthdd%10;
   		int fifthdd = (int) numy/100000;
   		int sixd = (int) fifthdd%10;
   		int sixdd = (int) numy/1000000;
   		int svd = (int) sixdd%10;
   		
   		
   		System.out.println(fd);
   		System.out.println(sd);
   		System.out.println(td);
   		System.out.println(fthd);
   		System.out.println(fifthd);
   		System.out.println(sixd);
   		System.out.println(svd);
   		
   		
   		if(locale()=="English") {
   			
   			if(numy<0)
   				return "minus"+" "+ NumToWord(-numy);
   				
   			else if(numy<20 && numy>=0)
   	   			if(sd!=0)
   	   				return teens[fd];
   	   			else
   	   				return digits[fd];

   	   		else if(numy>=20 && numy<100)
   	   			return tens[sd] + " " + digits[fd];
   	   		
   	   		else if(numy>=100 && numy<1000)
   	   			if(sd==1)
   	   				return digits[td]+" "+"hundred"+" "+teens[fd];
   	   			else
   	   				return digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   	   		
   	   		else if(numy>=1000 && numy<1000000)
   	   			if(td!=0)
   		   			if(fifthd==0 && sixd==0 && sd==1)
   		   				return digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+teens[fd];
   		   			else if(fifthd==0 && sixd==0)
   		   				return digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   		   			else if(fifthd==1 && sixd==0 && sd==1)
   		   				return teens[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+teens[fd];
   		   			else if(fifthd==1 && sixd==0)
   		   				return teens[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   		   			else if(sixd==0 && sd==1)
   		   				return tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+teens[fd];
   		   			else if(sixd==0)
   		   				return tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   		   			else if(fifthd==1 && sd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+teens[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+teens[fd];
   		   			else if(fifthd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+teens[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   		   			else if(sd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+teens[fd];
   		   			else 
   		   				return digits[sixd]+" "+"hundred"+" "+tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+digits[td]+" "+"hundred"+" "+tens[sd]+" "+digits[fd];
   	   			else
   	   				if(fifthd==0 && sixd==0 && sd==1)
   		   				return digits[fthd]+" "+"thousand"+" "+teens[fd];
   		   			else if(fifthd==0 && sixd==0)
   		   				return digits[fthd]+" "+"thousand"+" "+tens[sd]+" "+digits[fd];
   		   			else if(fifthd==1 && sixd==0 && sd==1)
   		   				return teens[fthd]+" "+"thousand"+" "+teens[fd];
   		   			else if(fifthd==1 && sixd==0)
   		   				return teens[fthd]+" "+"thousand"+" "+tens[sd]+" "+digits[fd];
   		   			else if(sixd==0 && sd==1)
   		   				return tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+teens[fd];
   		   			else if(sixd==0)
   		   				return tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+tens[sd]+" "+digits[fd];
   		   			else if(fifthd==1 && sd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+teens[fthd]+" "+"thousand"+" "+teens[fd];
   		   			else if(fifthd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+teens[fthd]+" "+"thousand"+" "+digits[td]+" "+tens[sd]+" "+digits[fd];
   		   			else if(sd==1)
   		   				return digits[sixd]+" "+"hundred"+" "+tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+teens[fd];
   		   			else 
   		   				return digits[sixd]+" "+"hundred"+" "+tens[fifthd]+" "+digits[fthd]+" "+"thousand"+" "+tens[sd]+" "+digits[fd];
   		   	else if(numy>=1000000 && numy<1000000000)
   	   			return NumToWord(numy / 1000000) +" "+"million" +" "+NumToWord(numy % 1000000);
   	   		
   	   		else if(numy>=1000000000 && numy<1000000000000l)
   	   			return NumToWord(numy / 1000000000) +" "+"billion" +" "+NumToWord(numy % 1000000000);
   	   		
   	   		else if(numy>=1000000000000l && numy<1000000000000000l)
   	   			return NumToWord(numy / 1000000000000l) +" "+"trillion" +" "+NumToWord(numy % 1000000000000l);
   		}
   		
   		else if(locale()=="Turkish") {
   			if(numy<0)
   				return "eksi"+" "+ NumToWord(-numy);
   			else if(numy>=0 && numy<100)
   	   			return onlar[sd] +" "+birler[fd];
   	   		
   	   		else if(numy>=100 && numy<1000)
   	   			if(td==1)
   					return "yüz"+" "+onlar[sd]+" "+birler[fd];
   	   			else
   	   				return birler[td]+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
   	   		
   	   		else if(numy>=1000 && numy<1000000) {
   	   			
	   	   		if(td==1)
		   			if(fifthd==0 && sixd==0 && fthd!=1)
		   				return birler[fthd]+" "+"bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
		   			else if(fifthd==0 && sixd==0 && fthd==1)
		   				return "bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
		   			else if(sixd==0)
		   				return onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
		   			else if(sixd==1)
		   				return "yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
		   			else
		   				return birler[sixd]+" "+"yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
   	   			

   	   			else if(td==0)
   		   			if(fifthd==0 && sixd==0 && fthd!=1)
   		   				return birler[fthd]+" "+"bin"+" "+onlar[sd]+" "+birler[fd];
   		   			else if(fifthd==0 && sixd==0 && fthd==1)
   		   				return "bin"+" "+onlar[sd]+" "+birler[fd];
   		   			else if(sixd==0)
   		   				return onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+onlar[sd]+" "+birler[fd];
	   		   		else if(sixd==1)
		   				return "yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+birler[td]+" "+onlar[sd]+" "+birler[fd];
   		   			else 
   		   				return birler[sixd]+" "+"yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+onlar[sd]+" "+birler[fd];
   				
	   	   		else if(td!=0 && td!=1)
   		   			if(fifthd==0 && sixd==0 && fthd!=1)
   		   				return birler[fthd]+" "+"bin"+" "+birler[td]+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
   		   			else if(fifthd==0 && sixd==0 && fthd==1)
		   				return "bin"+" "+birler[td]+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
   		   			else if(sixd==0)
   		   				return onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+birler[td]+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
	   		   		else if(sixd==1)
		   				return "yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];
   		   			else 
   		   				return birler[sixd]+" "+"yüz"+" "+onlar[fifthd]+" "+birler[fthd]+" "+"bin"+" "+birler[td]+" "+"yüz"+" "+onlar[sd]+" "+birler[fd];}
   	   			
   		   	else if(numy>=1000000 && numy<1000000000)
   	   			return NumToWord(numy / 1000000) +" "+"milyon"+" "+NumToWord(numy % 1000000);
   	   		
   	   		else if(numy>=1000000000 && numy<1000000000000l)
   	   			return NumToWord(numy / 1000000000) +" "+"milyar"+" "+NumToWord(numy % 1000000000);
   	   		
   	   		else if(numy>=1000000000000l && numy<1000000000000000l)
   	   			return NumToWord(numy / 1000000000000l) +" "+"trilyon" +" "+NumToWord(numy % 1000000000000l);
   			
   		}
   		

   		return "";
   			
   		}   					
}