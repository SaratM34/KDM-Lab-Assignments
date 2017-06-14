    import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
    import edu.stanford.nlp.hcoref.data.CorefChain;
    import edu.stanford.nlp.ling.CoreAnnotations;
    import edu.stanford.nlp.ling.CoreLabel;
    import edu.stanford.nlp.pipeline.Annotation;
    import edu.stanford.nlp.pipeline.StanfordCoreNLP;
    import edu.stanford.nlp.semgraph.SemanticGraph;
    import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
    import edu.stanford.nlp.trees.Tree;
    import edu.stanford.nlp.trees.TreeCoreAnnotations;
    import edu.stanford.nlp.util.CoreMap;


    import java.nio.file.Files;
    import java.util.List;
    import java.util.Map;
    import java.util.Properties;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.*;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Scanner;



    public class Nlp {
        public static void main(String args[]) throws IOException {

            Properties know = new Properties();
            know.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
            StanfordCoreNLP mainline = new StanfordCoreNLP(know);


            //String sent = "data";

            /*To read from given input file*/
            String sent = new String(Files.readAllBytes(Paths.get("C:/Users/user/Desktop/bbcsport/001.txt")));




            Annotation doc = new Annotation(sent);


            mainline.annotate(doc);
            List<CoreMap> sentences = doc.get(CoreAnnotations.SentencesAnnotation.class);

            for (CoreMap sentence : sentences) {

                for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                    System.out.println("\n" + token);

    
                    String wo = token.get(CoreAnnotations.TextAnnotation.class);
                    System.out.println("TA");
                    System.out.println(token + ":" + wo);


                    String lem = token.get(CoreAnnotations.LemmaAnnotation.class);
                    System.out.println("LA");
                    System.out.println(token + ":" + lem);



                    String part = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    System.out.println("Part");
                    System.out.println(token + ":" + part);


                    String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    System.out.println("Name");
                    System.out.println(token + ":" + ne);

                    System.out.println("\n\n");
                }


                Tree leaf = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
                System.out.println(leaf);
                SemanticGraph imp = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
                System.out.println(imp.toString());

                Map<Integer, CorefChain> vis =
                        doc.get(CorefCoreAnnotations.CorefChainAnnotation.class);
                System.out.println(vis.values().toString());
            }

        }
    }
