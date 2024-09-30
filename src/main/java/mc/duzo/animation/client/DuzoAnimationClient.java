package mc.duzo.animation.client;

import mc.duzo.animation.generic.AnimationTracker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import mc.duzo.animation.network.PlayAnimationS2CPacket;
import mc.duzo.animation.registry.client.TrackerRegistry;

public class DuzoAnimationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TrackerRegistry.init();

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> TrackerRegistry.REGISTRY.forEach(AnimationTracker::onDisconnect));

        ClientPlayNetworking.registerGlobalReceiver(PlayAnimationS2CPacket.TYPE, PlayAnimationS2CPacket::handle);
    }
}
