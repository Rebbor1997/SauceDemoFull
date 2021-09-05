package endpoints;

public interface MilestonesEndpoints {
    String get_milestone = "/index.php?/api/v2/get_milestone/%s";
    String get_milestones = "/index.php?/api/v2/get_milestones/%s";
    String add_milestones = "index.php?/api/v2/add_milestone/%s";
    String update_milestones = "index.php?/api/v2/update_milestone/%s";
    String delete_milestones = "index.php?/api/v2/delete_milestone/%s";


}
