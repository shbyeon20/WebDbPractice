package DBpractice2;

public class DbTestMain {
    public static void main(String[] args) {
       // Member member = new Member();
       // Scanner scanner = new Scanner(System.in);
        //scanner.nextInt();
        DbService dbService = new DbService();
        System.out.println(dbService.memberList().toString());
       //dbTest.DbInsert();
       //dbTest.DbUpdate();
       //dbService.Dbdelete();



    }
}
