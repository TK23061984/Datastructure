package algorithms.dynamicProgramming;

import java.util.*;

import org.junit.Assert;
import org.testng.annotations.Test;

/*
 * https://leetcode.com/problems/word-break/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class String19_WordBreak {
	
	@Test
	private void test() {
		String s= "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
		String dic = "kfomka,hecagbngambii,anobmnikj,c,nnkmfelneemfgcl,ah,bgomgohl,lcbjbg,ebjfoiddndih,hjknoamjbfhckb,eioldlijmmla,nbekmcnakif,fgahmihodolmhbi,gnjfe,hk,b,jbfgm,ecojceoaejkkoed,cemodhmbcmgl,j,gdcnjj,kolaijoicbc,liibjjcini,lmbenj,eklingemgdjncaa,m,hkh,fblb,fk,nnfkfanaga,eldjml,iejn,gbmjfdooeeko,jafogijka,ngnfggojmhclkjd,bfagnfclg,imkeobcdidiifbm,ogeo,gicjog,cjnibenelm,ogoloc,edciifkaff,kbeeg,nebn,jdd,aeojhclmdn,dilbhl,dkk,bgmck,ohgkefkadonafg,labem,fheoglj,gkcanacfjfhogjc,eglkcddd,lelelihakeh,hhjijfiodfi,enehbibnhfjd,gkm,ggj,ag,hhhjogk,lllicdhihn,goakjjnk,lhbn,fhheedadamlnedh,bin,cl,ggjljjjf,fdcdaobhlhgj,nijlf,i,gaemagobjfc,dg,g,jhlelodgeekj,hcimohlni,fdoiohikhacgb,k,doiaigclm,bdfaoncbhfkdbjd,f,jaikbciac,cjgadmfoodmba,molokllh,gfkngeebnggo,lahd,n,ehfngoc,lejfcee,kofhmoh,cgda,de,kljnicikjeh,edomdbibhif,jehdkgmmofihdi,hifcjkloebel,gcghgbemjege,kobhhefbbb,aaikgaolhllhlm,akg,kmmikgkhnn,dnamfhaf,mjhj,ifadcgmgjaa,acnjehgkflgkd,bjj,maihjn,ojakklhl,ign,jhd,kndkhbebgh,amljjfeahcdlfdg,fnboolobch,gcclgcoaojc,kfokbbkllmcd,fec,dljma,noa,cfjie,fohhemkka,bfaldajf,nbk,kmbnjoalnhki,ccieabbnlhbjmj,nmacelialookal,hdlefnbmgklo,bfbblofk,doohocnadd,klmed,e,hkkcmbljlojkghm,jjiadlgf,ogadjhambjikce,bglghjndlk,gackokkbhj,oofohdogb,leiolllnjj,edekdnibja,gjhglilocif,ccfnfjalchc,gl,ihee,cfgccdmecem,mdmcdgjelhgk,laboglchdhbk,ajmiim,cebhalkngloae,hgohednmkahdi,ddiecjnkmgbbei,ajaengmcdlbk,kgg,ndchkjdn,heklaamafiomea,ehg,imelcifnhkae,hcgadilb,elndjcodnhcc,nkjd,gjnfkogkjeobo,eolega,lm,jddfkfbbbhia,cddmfeckheeo,bfnmaalmjdb,fbcg,ko,mojfj,kk,bbljjnnikdhg,l,calbc,mkekn,ejlhdk,hkebdiebecf,emhelbbda,mlba,ckjmih,odfacclfl,lgfjjbgookmnoe,begnkogf,gakojeblk,bfflcmdko,cfdclljcg,ho,fo,acmi,oemknmffgcio,mlkhk,kfhkndmdojhidg,ckfcibmnikn,dgoecamdliaeeoa,ocealkbbec,kbmmihb,ncikad,hi,nccjbnldneijc,hgiccigeehmdl,dlfmjhmioa,kmff,gfhkd,okiamg,ekdbamm,fc,neg,cfmo,ccgahikbbl,khhoc,elbg,cbghbacjbfm,jkagbmfgemjfg,ijceidhhajmja,imibemhdg,ja,idkfd,ndogdkjjkf,fhic,ooajkki,fdnjhh,ba,jdlnidngkfffbmi,jddjfnnjoidcnm,kghljjikbacd,idllbbn,d,mgkajbnjedeiee,fbllleanknmoomb,lom,kofjmmjm,mcdlbglonin,gcnboanh,fggii,fdkbmic,bbiln,cdjcjhonjgiagkb,kooenbeoongcle,cecnlfbaanckdkj,fejlmog,fanekdneoaammb,maojbcegdamn,bcmanmjdeabdo,amloj,adgoej,jh,fhf,cogdljlgek,o,joeiajlioggj,oncal,lbgg,elainnbffk,hbdi,femcanllndoh,ke,hmib,nagfahhljh,ibifdlfeechcbal,knec,oegfcghlgalcnno,abiefmjldmln,mlfglgni,jkofhjeb,ifjbneblfldjel,nahhcimkjhjgb,cdgkbn,nnklfbeecgedie,gmllmjbodhgllc,hogollongjo,fmoinacebll,fkngbganmh,jgdblmhlmfij,fkkdjknahamcfb,aieakdokibj,hddlcdiailhd,iajhmg,jenocgo,embdib,dghbmljjogka,bahcggjgmlf,fb,jldkcfom,mfi,kdkke,odhbl,jin,kcjmkggcmnami,kofig,bid,ohnohi,fcbojdgoaoa,dj,ifkbmbod,dhdedohlghk,nmkeakohicfdjf,ahbifnnoaldgbj,egldeibiinoac,iehfhjjjmil,bmeimi,ombngooicknel,lfdkngobmik,ifjcjkfnmgjcnmi,fmf,aoeaa,an,ffgddcjblehhggo,hijfdcchdilcl,hacbaamkhblnkk,najefebghcbkjfl,hcnnlogjfmmjcma,njgcogemlnohl,ihejh,ej,ofn,ggcklj,omah,hg,obk,giig,cklna,lihaiollfnem,ionlnlhjckf,cfdlijnmgjoebl,dloehimen,acggkacahfhkdne,iecd,gn,odgbnalk,ahfhcd,dghlag,bchfe,dldblmnbifnmlo,cffhbijal,dbddifnojfibha,mhh,cjjol,fed,bhcnf,ciiibbedklnnk,ikniooicmm,ejf,ammeennkcdgbjco,jmhmd,cek,bjbhcmda,kfjmhbf,chjmmnea,ifccifn,naedmco,iohchafbega,kjejfhbco,anlhhhhg";
		String[] dic_words = dic.split(",");
		List<String> wordDict = new ArrayList<String>();
		for(String word:dic_words) {
			wordDict.add(word);
		}
		Assert.assertEquals(wordBreak_dp(s,wordDict), true);
	}
	public boolean wordBreak_dp(String s, List<String> wordDict) {
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        int maxLen = 0;
        for(String word: wordDict) {
        	maxLen = Math.max(maxLen, word.length());
        }
        dp[0] = true;
        
        for(int i=0; i <= s.length();i++){
        	for(int j=i-1; j>=0;j--){
        		if(i-j > maxLen) {
        			continue;
        		}
            String word = s.substring(j,i);
            if(dp[j]&& wordDict.contains(word)){
                dp[i] = true;
                break;
            }
          }
        }
        return dp[n];
	}   
}