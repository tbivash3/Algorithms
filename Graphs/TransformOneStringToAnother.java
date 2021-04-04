package Graphs;

import java.util.*;

public class TransformOneStringToAnother {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("bat", "cot", "dog", "dag", "dot", "cat"));
        String input = "cat";
        String output = "bat";

        Map<String, String> visited = new HashMap<>();
        bfs(dictionary, input, output, visited);
        LinkedList<String> path = (LinkedList<String>) validatePath(visited, output, input);
        System.out.println(path.toString());
    }

    private static List<String> validatePath(Map<String, String> visited, String output, String input) {

       LinkedList<String> list = new LinkedList<>();
       list.addFirst(output);
       while(output != input) {
           list.addFirst(visited.get(output));
           output = visited.get(output);
       }

       return list;
    }

    private static void bfs(Set<String> dictionary, String input, String output, Map<String, String> visited) {

        if(input.equals(output)) return;

        List<String> adjacents = findAdjacents(dictionary, input);

        for(String adjacent: adjacents) {
            if (!visited.containsKey(adjacent)) {
                visited.put(adjacent, input);
                bfs(dictionary, adjacent, output, visited);
            }
        }

    }

    private static List<String> findAdjacents(Set<String> dictionary, String input) {
        List<String> adjacents = new ArrayList<>();

        for(String temp: dictionary) {
            if(temp.length() == input.length()) {
                int diff = 0;

                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) != temp.charAt(i)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    adjacents.add(temp);
                }
            }
        }
        return adjacents;
    }
}
