package NecessePets.mod;

import necesse.engine.registries.MobRegistry;
import necesse.engine.tickManager.TickManager;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.leaves.PlayerFollowerAINode;
import necesse.entity.mobs.summon.summonFollowingMob.petFollowingMob.PetFollowingMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

import java.awt.*;
import java.util.List;

public class AVMob extends PetFollowingMob {
    public static GameTexture texture;
    public AVMob() {
        super(10);
        this.setSpeed(50.0F);
        this.setFriction(2.0F);
        this.moveAccuracy = 10;
        this.collision = new Rectangle(-64, -64, 16, 16);
        this.hitBox = new Rectangle(-64, 64, 16, 16);
        this.selectBox = new Rectangle(-64, -64, 16, 16);
    }

    public void init() {
        super.init();
        this.ai = new BehaviourTreeAI(this, new PlayerFollowerAINode(480, 64));
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        for(int i = 0; i < 4; ++i) {
            this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), MobRegistry.Textures.penguin, i, 4, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC);
        }

    }

    protected TextureDrawOptions getShadowDrawOptions(int x, int y, GameLight light, GameCamera camera) {
        GameTexture shadowTexture = MobRegistry.Textures.human_baby_shadow;
        int res = shadowTexture.getHeight();
        int drawX = camera.getDrawX(x) - res / 2;
        int drawY = camera.getDrawY(y) - res / 2;
        drawY += this.getBobbing(x, y);
        return shadowTexture.initDraw().sprite(this.dir, 0, res).light(light).pos(drawX, drawY);
    }
    protected void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        // Tile positions are basically level positions divided by 32. getTileX() does this for us etc.
        GameLight light = level.getLightLevel(getTileX(), getTileY());
        int drawX = camera.getDrawX(x)-16;
        int drawY = camera.getDrawY(y)-32;

        // A helper method to get the sprite of the current animation/direction of this mob
        Point sprite = getAnimSprite(x, y, 0);
        drawY += getBobbing(x, y);
        drawY += getLevel().getTile(getTileX(), getTileY()).getMobSinkingAmount(this);

        DrawOptions drawOptions = texture.initDraw().light(light).pos(drawX,drawY);
                /*.sprite(sprite.x, sprite.y, 64)
                .light(light)
                .pos(drawX, drawY);
*/
        list.add(new MobDrawable() {
            @Override
            public void draw(TickManager tickManager) {
                drawOptions.draw();
            }
        });

        addShadowDrawables(tileList, x, y, light, camera);
    }


    public int getRockSpeed() {
        return 10;
    }
}
