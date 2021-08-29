package endpoints;

public interface ProjectEndpoints {
    String add_project = "/index.php?/api/v2/add_project";
    String get_project = "/index.php?/api/v2/get_project/%s";
    String get_projects = "/index.php?/api/v2/get_projects";
    String update_project = "/index.php?/api/v2/update_project/%d";
}
