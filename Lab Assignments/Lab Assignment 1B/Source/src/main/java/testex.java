
import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
import edu.stanford.nlp.hcoref.data.CorefChain;
import edu.stanford.nlp.hcoref.data.Mention;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class testex {
    public static void main(String[] args) throws Exception {
        Annotation doc = new Annotation("Example text");
        Properties pro = new Properties();
        pro.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,mention,coref");
        StanfordCoreNLP pop = new StanfordCoreNLP(pro);
        pop.annotate(doc);
        System.out.println("---");
        System.out.println("coref chains");
        for (CorefChain cc : doc.get(CorefCoreAnnotations.CorefChainAnnotation.class).values()) {
            System.out.println("\t" + cc);
        }
        for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
            System.out.println("---");
            System.out.println("mentions");
            for (Mention m : sentence.get(CorefCoreAnnotations.CorefMentionsAnnotation.class)) {
                System.out.println("\t" + m);
            }
        }
    }
}
