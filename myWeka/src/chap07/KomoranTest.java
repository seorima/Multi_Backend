package chap07;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

public class KomoranTest {
	
	public static void main(String[] args) {
		String content = "별 반개도 아깝다 욕나온다 이응경 길용우 연기생활이몇년인지..정말 발로해도 그것보단 낫겟다 납치.감금만반복반복..이드라마는 가족도없다 연기못하는사람만모엿네";
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		
		KomoranResult result = komoran.analyze(content);
		System.out.println(result.getPlainText());
		
		List<String> wordList = result.getMorphesByTags("NNG","NNP","NNB","NP","NR","VV","VA","VX","VCN","VCP","IC");
		System.out.println(content);
		
		for(String wordString : wordList) {
			System.out.print(wordString + " ");
		}
	}

}
