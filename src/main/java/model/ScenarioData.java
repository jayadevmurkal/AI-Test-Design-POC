package model;

public class ScenarioData {

    private String scenario;
    private String email;
    private String password;
    private String confirmPassword;
    private String expectedResult;
    private String getterMethod;

    public ScenarioData() {
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getGetterMethod() {
        return getterMethod;
    }

    public void setGetterMethod(String getterMethod) {
        this.getterMethod = getterMethod;
    }
}