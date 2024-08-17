package spooketti.smashketti;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import spooketti.smashketti.moves.ClientGrab;
import spooketti.smashketti.moves.ClientSmashAttack;

public class SmashkettiClient implements ClientModInitializer {

	public static final KeyBinding smashAttack = KeyBindingHelper. registerKeyBinding(
			new KeyBinding("key.smashketti.smash",
					InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
					"key.smashketti.smashcontrol"));

	public static final KeyBinding grab = KeyBindingHelper. registerKeyBinding(
			new KeyBinding("key.smashketti.grab",
					InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G,
					"key.smashketti.smashcontrol"));


	@Override
	public void onInitializeClient() {

		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientTickEvents.END_CLIENT_TICK.register(ClientSmashAttack::smashAttackLogic);
		ClientTickEvents.END_CLIENT_TICK.register(ClientGrab::grabLogic);
//		ClientTickEvents.END_CLIENT_TICK.register(SideCamera::cameraLogic);
	}

}