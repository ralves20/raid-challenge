public class LemonadeStandComponent {


    public static String groupName(String name) {
       return "groupList.findAll{it.name=='" + name + "'}.name";
    }
}
