import com.nexus.domain.Author;

public class Main {

    public static void main(String[] args) {
        Author author = new Author("Mohammed", "Albany", "Abdul Rahman");
        System.out.println(author.isMiddleNull());
    }

}
