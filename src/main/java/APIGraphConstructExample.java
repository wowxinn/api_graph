import model.MyGraph;
import model.node.MyNode;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * APIGraphConstructExample
 * 利用JavaParser 构造 {@link MyGraph}的例子
 * 主要解析代码在 {@link GraphBuilder}中
 * @author wangxin
 */
public class APIGraphConstructExample {
    public static void main(String[] args) {

        GraphBuilder builder = new GraphBuilder();
        File fileToParse = new File("./src/main/java/APIGraphConstructExample.java");
        String path = fileToParse.getPath();
        List<MyGraph> gs = builder.build(fileToParse, path);
        System.out.println("build Graph done, num: " + gs.size());

        SequenceExtractor se = new SequenceExtractor();
        LinkedList<LinkedList<MyNode>> apiSequence = new LinkedList<>();
        for (MyGraph g: gs) {
            System.out.println(g);
            apiSequence.addAll(se.getAPISequence(g));
        }
        System.out.println("build API sequence done, num " + apiSequence.size());
    }
}
