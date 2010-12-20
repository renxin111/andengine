package org.anddev.andengine.entity;

import java.util.ArrayList;
import java.util.Comparator;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.runnable.RunnableHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.opengl.IDrawable;
import org.anddev.andengine.util.IEntityMatcher;
import org.anddev.andengine.util.modifier.IModifier;


/**
 * @author Nicolas Gramlich
 * @since 11:20:25 - 08.03.2010
 */
public interface IEntity extends IDrawable, IUpdateHandler {
	// ===========================================================
	// Final Fields
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	public float getRed();
	public float getGreen();
	public float getBlue();
	public float getAlpha();
	public void setAlpha(final float pAlpha);

	public void setColor(final float pRed, final float pGreen, final float pBlue);
	public void setColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha);

	public float getX();
	public float getY();

	public float getBaseX();
	public float getBaseY();

	public void setBasePosition();
	public void setPosition(final IEntity pOtherEntity);
	public void setPosition(final float pX, final float pY);
	
	public float[] getSceneCenterCoordinates();

	public float getRotation();
	public void setRotation(final float pRotation);

	public float getRotationCenterX();
	public float getRotationCenterY();
	public void setRotationCenterX(final float pRotationCenterX);
	public void setRotationCenterY(final float pRotationCenterY);
	public void setRotationCenter(final float pRotationCenterX, final float pRotationCenterY);

	public boolean isScaled();
	public float getScaleX();
	public float getScaleY();
	public void setScaleX(final float pScaleX);
	public void setScaleY(final float pScaleY);
	public void setScale(final float pScale);
	public void setScale(final float pScaleX, final float pScaleY);

	public float getScaleCenterX();
	public float getScaleCenterY();
	public void setScaleCenterX(final float pScaleCenterX);
	public void setScaleCenterY(final float pScaleCenterY);
	public void setScaleCenter(final float pScaleCenterX, final float pScaleCenterY);

	public void addEntityModifier(final IModifier<IEntity> pEntityModifier);
	public boolean removeEntityModifier(final IModifier<IEntity> pEntityModifier);
	public void clearEntityModifiers();

	public int getZIndex();
	public void setZIndex(final int pZIndex);

	public int getChildCount();

	public void addChild(final IEntity pEntity);
	
	public void setChild(final int pEntityIndex, final IEntity pEntity); // TODO Is working on indexes desireable? Or maybe work on zIndexes or a tag like Cocos2D does. 

	/**
	 * Similar to {@link ILayer#setChild(int, ILayer)} but returns the {@link IEntity} that would be overwritten.
	 * 
	 * @param pEntityIndex
	 * @param pEntity
	 * @return the layer that has been replaced.
	 */
	public IEntity replaceChild(final int pEntityIndex, final IEntity pEntity);

	public void swapChildren(final int pEntityIndexA, final int pEntityIndexB);

	public IEntity getChild(final int pIndex);
	public IEntity getFirstChild();
	public IEntity getLastChild();

	public IEntity findChild(final IEntityMatcher pEntityMatcher);
	
	/**
	 * Sorts the {@link IEntity}s based on their ZIndex. Sort is stable. 
	 */
	public void sortChildren();
	
	/**
	 * Sorts the {@link IEntity}s based on the {@link Comparator} supplied. Sort is stable.
	 * @param pEntityComparator
	 */
	public void sortChildren(final Comparator<IEntity> pEntityComparator);

	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link ArrayIndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public IEntity removeChild(final int pIndex); // TODO Is working on indexes desireable? Or maybe work on zIndexes or a tag like Cocos2D does.
	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link ArrayIndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public boolean removeChild(final IEntity pEntity);
	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link ArrayIndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public boolean removeChild(final IEntityMatcher pEntityMatcher);

	public void clearChildren();

	public ArrayList<ITouchArea> getTouchAreas();
	public void registerTouchArea(final ITouchArea pTouchArea);
	public void unregisterTouchArea(final ITouchArea pTouchArea);
}
