package com.brashmonkey.spriter;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-07-16.
 */
public class SpriterDrawable implements Comparable<SpriterDrawable>
{
	private SpriterSprite sprite;
	private int zIndex;

	public SpriterDrawable(SpriterSprite sprite, int zIndex)
	{
		this.sprite = sprite;
		this.zIndex = zIndex;
	}

	public void draw(Batch batch)
	{
		if(sprite.getAsset() == null || sprite.getAsset().getTexture() == null)
			return;

		float width = sprite.getAsset().getRegionWidth();
		float height = sprite.getAsset().getRegionHeight();

		float originX = width * sprite.getAsset().getPivotX();
		float originY = height * sprite.getAsset().getPivotY();

		float prevColor = batch.getPackedColor();

		batch.getColor().a *= sprite.getAlpha();
		batch.setColor(batch.getColor());

		batch.draw(sprite.getAsset(),
				sprite.getPosition().x - originX,
				sprite.getPosition().y - originY,
				originX,
				originY,
				width,
				height,
				sprite.getScale().x,
				sprite.getScale().y,
				sprite.getAngle());

		batch.setColor(prevColor);
	}


	@Override
	public int compareTo(SpriterDrawable other)
	{
		return Integer.compare(zIndex, other.getZIndex());
	}

	public SpriterSprite getSprite()
	{
		return sprite;
	}

	public void setSprite(SpriterSprite sprite)
	{
		this.sprite = sprite;
	}

	public int getZIndex()
	{
		return zIndex;
	}

	public void setzIndex(int zIndex)
	{
		this.zIndex = zIndex;
	}
}
