public class MyString {
    private String content;

    public MyString(){}
    public MyString(String content){
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int length(){
        return content.length();
    }

    public void searchForNumber() throws NotValidTextException {
        for(int i=0;i<=9;i++) if (content.contains(""+i))
        throw new NotValidTextException("Error: This text is not valid because contains number!");
    }
}
