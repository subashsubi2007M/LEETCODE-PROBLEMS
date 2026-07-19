import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String person, List<String> order) {

        // Add the person if they are alive
        if (!dead.contains(person)) {
            order.add(person);
        }

        // Visit all children in birth order
        for (String child : family.getOrDefault(person, new ArrayList<>())) {
            dfs(child, order);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName, childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
