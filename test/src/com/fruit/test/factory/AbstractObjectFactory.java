package src.com.fruit.test.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class AbstractObjectFactory<T> implements IObjectFactory<T> {

	private Random random = new Random();

	protected List<T> persistedObjectList = new ArrayList<>();

	protected List<T> nonPersistedObjectList = new ArrayList<>();

	// -------------------------------------------

	/*
	 ************************* Persisted **************************
	 */

	/**
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#add(java.lang.Object)
	 */
	@Override
	public void addPersisted( T obj ) {

		// remove the same obj from non-persisted and persisted object list

		removeFromList( obj, nonPersistedObjectList );
		removeFromList( obj, persistedObjectList );
		
		persistedObjectList.add( obj );

	}

	/**
	 * @throws Exception
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#addAll(java.util.List)
	 */
	@Override
	public void addAllPersisted( List<T> objList ) {
		if( objList != null ) {
			for( T obj : objList ) {
				addPersisted( obj );
			}
		}
	}

	/**
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getPersisted()
	 */
	@Override
	public T getPersisted() {

		if( persistedObjectList.size() > 0 ) {
			return persistedObjectList.get( random.nextInt( persistedObjectList.size() ) );
		}

		return null;

	}

	/**
	 * @throws Exception
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getPersisted(int)
	 */
	@Override
	public List<T> getPersisted( int num ) throws Exception {

		if( num > persistedObjectList.size() ) {
			throw new Exception( "Number requested is more than what's in the object list." );
		}

		if( num <= 0 ) {
			return new ArrayList<>();
		}

		Collections.shuffle( persistedObjectList );

		return persistedObjectList.subList( 0, num );

	}

	/**
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getAllPersisted()
	 */
	@Override
	public List<T> getAllPersisted() {
		return persistedObjectList;
	}

	/**
	 * @see com.fruit.cpfr.test.factory.IObjectFactory#removePersisted(java.lang.Object)
	 */
	@Override
	public void removePersisted( T obj ) {

		// remove the same obj from persisted object list

		removeFromList( obj, persistedObjectList );
		
	}
	
	/*
	 ************************* Non-Persisted ****************************
	 */

	/**
	 * @throws Exception
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getNonPersisted()
	 */
	@Override
	public T getNonPersisted() throws Exception {

		prepareNonPersistedList();

		if( nonPersistedObjectList.size() > 0 ) {
			return nonPersistedObjectList.get( random.nextInt( nonPersistedObjectList.size() ) );
		}

		return null;

	}

	/**
	 * @throws Exception
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getNonPersisted(int)
	 */
	@Override
	public List<T> getNonPersisted( int num ) throws Exception {

		prepareNonPersistedList();

		if( num > nonPersistedObjectList.size() ) {
			throw new Exception( "Number requested is more than what's in the object list." );
		}

		if( num <= 0 ) {
			return new ArrayList<>();
		}

		Collections.shuffle( nonPersistedObjectList );

		/*
		 *  must return a new reference because when calling addPersisted it will loop through this list
		 *  java.util.ConcurrentModificationException will occur if addPersisted is called inside of a loop of this list
		 */
		return new ArrayList<>( nonPersistedObjectList.subList( 0, num ) );

	}

	/**
	 * @throws Exception
	 * @see com.fruit.optimusbom.test.factory.IObjectFactory#getAllNonPersisted()
	 */
	@Override
	public List<T> getAllNonPersisted() throws Exception {

		prepareNonPersistedList();

		/*
		 *  must return a new reference because when calling addPersisted it will loop through this list
		 *  java.util.ConcurrentModificationException will occur if addPersisted is called inside of a loop of this list
		 */
		return new ArrayList<>( nonPersistedObjectList );

	}

	private void prepareNonPersistedList() throws Exception {
		if( nonPersistedObjectList.size() == 0 && persistedObjectList.size() == 0) {
			setupNonPersistedList();
		}
	}
	
	private void removeFromList( T obj, List<T> list ) {
		
		T itemToRemove = null;
		
		for( T persistedObj : list ) {

			if( compare( persistedObj, obj ) ) {
				itemToRemove = persistedObj;
			}

		}

		list.remove( itemToRemove );
		
	}
	
	protected abstract void setupNonPersistedList() throws Exception;

	/**
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected abstract boolean compare( T obj1, T obj2 );

	// -------------------------------------------

	protected Random getRandom() {
		return random;
	}

}

