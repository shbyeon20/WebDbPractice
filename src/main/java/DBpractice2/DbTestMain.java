package DBpractice2;

public class DbTestMain {
    public static void main(String[] args) {
       // Member member = new Member();
       // Scanner scanner = new Scanner(System.in);
        //scanner.nextInt();
        MemberService memberService = new MemberService();
        System.out.println(memberService.getMember("jj3@gmail.com").getMarketing_yn());
       //dbTest.DbInsert();
       //dbTest.DbUpdate();
       //dbService.Dbdelete();



    }
}
