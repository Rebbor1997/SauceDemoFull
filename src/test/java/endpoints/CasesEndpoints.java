package endpoints;

public interface CasesEndpoints {
    String get_case = "/index.php?/api/v2/get_case/%s";
    String get_cases = "index.php?/api/v2/get_cases/%s&suite_id=%s";
    String get_history_for_case = "index.php?/api/v2/get_history_for_case/%s";
    String add_case = "index.php?/api/v2/add_case/%s";
    String copy_cases_to_section = "index.php?/api/v2/copy_cases_to_section/%s";
    String update_case = "index.php?/api/v2/update_case/%s";
    String update_cases = "index.php?/api/v2/update_case/%s";
    String move_cases_to_section = "index.php?/api/v2/move_cases_to_section/%s";
    String delete_case = "index.php?/api/v2/delete_case/%s";
    String delete_cases = "index.php?/api/v2/delete_cases/%s&suite_id&soft=1";
}
