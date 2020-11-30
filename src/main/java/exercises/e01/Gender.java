package exercises.e01;

public enum Gender {
    /**
     * male -> 1 -> 男
     * female -> 2 -> 女
     */
    MALE(1, "male"),
    FEMALE(2, "female");

    private final Integer code;
    private final String value;

    Gender(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }
    public String getValue() {
        return value;
    }

    public static Gender formCode(Integer code){
        for(Gender e: Gender.values()){
            if(null != e.getCode() && e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }

    public static Gender formValue(String value){
        for(Gender e: Gender.values()){
            if(null != e.getValue() && e.getValue().equals(value)){
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
