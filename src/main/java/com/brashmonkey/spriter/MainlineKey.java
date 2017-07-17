package com.brashmonkey.spriter;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IdentityMap;
import com.brashmonkey.spriter.math.Curve;

/**
 * Represents a mainline key in a Spriter SCML file. A mainline key holds a {@link #time}, a {@link
 * #curve} and lists of bone and object references which build a tree hierarchy.
 *
 * @author Trixt0r
 */
public class MainlineKey
{
	public final int time;
	public final Array<ObjectRef> objectRefs;
	public final Curve curve;

	public MainlineKey(int time, Curve curve, Array<ObjectRef> objectRefs)
	{
		this.time = time;
		this.curve = curve;
		this.objectRefs = objectRefs;
	}

	public MainlineKey(MainlineKey other)
	{
		this.time = other.time;
		this.curve = other.curve;
		this.objectRefs = new Array<>(other.objectRefs.size);

		IdentityMap<ObjectRef, ObjectRef> graphIsomorphism = new IdentityMap<>(); //TODO add possibility to not create a new object (pooling or parameter?)

		for(ObjectRef ref : other.objectRefs)
			objectRefs.add(ref.clone(graphIsomorphism));
	}
}
