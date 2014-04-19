package parabot.strategy;

import java.awt.Point;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

public class CookStrategy implements Strategy {
    @Override
    public boolean activate() {
    	return (Inventory.getCount(parabot.KingCooker.rawFishId) >= 1);
    }

    @Override
    public void execute() {
    	final SceneObject[] ranges = SceneObjects.getNearest(2728);
    	final SceneObject range = ranges[0];
    	Point clickItem = new Point(700, 450);
    	Mouse.getInstance().click(clickItem);
    	range.interact("-> Range");
    	while (Inventory.getCount(parabot.KingCooker.rawFishId) >= 1) {
    		Time.sleep(500);
    	}   
    }
}
