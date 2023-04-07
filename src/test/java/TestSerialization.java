import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import week4.ReflectionFormatter;
import week4.Robot;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSerialization {

    private ReflectionFormatter formatter = new ReflectionFormatter();

    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public static void beforeClass(){
        robot = new Robot(1, "Robocop", 4000.5);
        robotStr = String.format("type:%s \nid:%s\nmodel:%s\nprice%s",
                robot.getClass().getName(),
                robot.getId(),
                robot.getModel(),
                robot.getPrice());
    }

    @Test
    public void _01testFormat(){
        String res = formatter.format(robot);
        Assert.assertEquals(robotStr, res);
    }

    @Test
    public void _02testParse(){
       Object object =  formatter.parse(robotStr);
        Assert.assertEquals(robot, object);
    }

}
