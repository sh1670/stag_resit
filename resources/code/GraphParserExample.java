import com.alexmerz.graphviz.*;
import com.alexmerz.graphviz.objects.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GraphParserExample {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            FileReader reader = new FileReader(args[0]);
            parser.parse(reader);
            ArrayList<Graph> graphs = parser.getGraphs();
            ArrayList<Graph> subGraphs = graphs.get(0).getSubgraphs();
            for(Graph g : subGraphs){
                System.out.printf("id = %s\n",g.getId().getId());

                ArrayList<Graph> subGraphs1 = g.getSubgraphs();
                for (Graph g1 : subGraphs1){
                    ArrayList<Node> nodesLoc = g1.getNodes(false);
                    Node nLoc = nodesLoc.get(0);
                    System.out.printf("\tid = %s, name = %s\n",g1.getId().getId(), nLoc.getId().getId());
                    ArrayList<Graph> subGraphs2 = g1.getSubgraphs();
                    for (Graph g2 : subGraphs2) {
                        System.out.printf("\t\tid = %s\n", g2.getId().getId());
                        ArrayList<Node> nodesEnt = g2.getNodes(false);
                        for (Node nEnt : nodesEnt) {
                            System.out.printf("\t\t\tid = %s, description = %s\n", nEnt.getId().getId(), nEnt.getAttribute("description"));
                        }
                    }
                }

                ArrayList<Edge> edges = g.getEdges();
                for (Edge e : edges){
                    System.out.printf("Path from %s to %s\n", e.getSource().getNode().getId().getId(), e.getTarget().getNode().getId().getId());
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (com.alexmerz.graphviz.ParseException pe) {
            System.out.println(pe);
        }
    }
      public static void readJSON(){
        String filepath = "data/basic-actions.json";
        JSONObject jObj = null;
        JSONParser parser = new JSONParser();
        try{
            jObj = (JSONObject) parser.parse(new FileReader(filepath));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONArray array = (JSONArray) jObj.get("actions");
        for(var v : array){
            JSONArray consumed = (JSONArray) ((JSONObject)v).get("consumed");
            JSONArray subjects = (JSONArray) ((JSONObject)v).get("subjects");
            JSONArray triggers = (JSONArray) ((JSONObject)v).get("triggers");
            String narration = (String)((JSONObject)v).get("narration");
            System.out.println(v);

        }
    }
}
