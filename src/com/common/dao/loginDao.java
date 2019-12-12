package common.dao;

import java.util.Map;

public interface loginDao {
    public Map<String,Object> checkpasword(Map<String,Object> val);

    public String checkuserName(Map<String,Object> val);
}
