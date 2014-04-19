package parabot.strategy;
import java.awt.Point;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Interfaces;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

public class BankStrategy implements Strategy {
    @Override
    public boolean activate() {	
    	return !(Inventory.getCount(parabot.KingCooker.getRawFishId()) >= 1);
    }

    @Override
    public void execute() {
    	final SceneObject[] banks = SceneObjects.getNearest(2213);
    	final SceneObject bankBooth = banks[0];
    	if (bankBooth != null) { 
    		Camera.turnTo(bankBooth);
    		bankBooth.interact("Use-quickly");
    		while (!(Interfaces.getOpenInterfaceId() == 23350)) {
    			Time.sleep(500);
    		}
    		Point depositAll = new Point(397, 300);
    		Mouse.getInstance().click(depositAll);
    		Time.sleep(500);
    		org.rev317.api.methods.Bank.withdraw(parabot.KingCooker.getRawFishId(),0,1000);
    		Point closeBank = new Point(488, 27);
    		Mouse.getInstance().click(closeBank);
    		while (Interfaces.getOpenInterfaceId() == 23350) {
    			Time.sleep(500);
    		}
    	}
    }
}	
