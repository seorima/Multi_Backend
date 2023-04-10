package chap07;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

public class KomoranTest {
	
	public static void main(String[] args) {
		String content = "�� �ݰ��� �Ʊ��� �峪�´� ������ ���� �����Ȱ�̸������..���� �߷��ص� �װͺ��� ���ٴ� ��ġ.���ݸ��ݺ��ݺ�..�̵�󸶴� ���������� ������ϴ»�����𿳳�";
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
