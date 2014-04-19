package parabot;
import java.util.ArrayList;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import parabot.strategy.BankStrategy;
import parabot.strategy.CookStrategy;
import parabot.strategy.WalkToRangeStrategy;
import parabot.gui.KingCookerGUI;

/**
Made by: king21200
 */
@ScriptManifest(author = "king21200", category = Category.COOKING, description = "Cooks food in Catherby, Start in bank, "
		+ "Make sure door is open so you can access the range before starting", name = "King_Cooker", servers = {"PKHonor"}, version = 1.2)
public class KingCooker extends Script {
private ArrayList<Strategy> strategies;
private static int rawFishId;
private static KingCookerGUI g;
private static boolean guiWait;

public static KingCookerGUI getG() {
	return g;
}

public void setG(KingCookerGUI g) {
	KingCooker.g = g;
}

public boolean isGuiWait() {
	return guiWait;
}

public static void setGuiWait(boolean guiWait) {
	KingCooker.guiWait = guiWait;
}

public static int getRawFishId() {
	return rawFishId;
}

public static void setRawFishId(int rawFishId) {
	KingCooker.rawFishId = rawFishId;
}

		@Override
        public boolean onExecute() {
        	setG(new KingCookerGUI());
        	strategies = new ArrayList<Strategy>();       
        	setGuiWait(true);
        	getG().setVisible(true);
            while (isGuiWait()) {
                Time.sleep(100);
            }
        	strategies.add(new BankStrategy());
        	strategies.add(new WalkToRangeStrategy());
        	strategies.add(new CookStrategy());
            provide(strategies);         
                return true;
        }

		@Override
        public void onFinish() {
 
        }
}