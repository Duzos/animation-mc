package mc.duzo.animation.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import mc.duzo.animation.network.PlayAnimationS2CPacket;
import mc.duzo.animation.registry.client.TrackerRegistry;

public class DuzoAnimationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TrackerRegistry.init();

        ClientPlayNetworking.registerGlobalReceiver(PlayAnimationS2CPacket.TYPE, PlayAnimationS2CPacket::handle);
    }
}
