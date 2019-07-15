package org.jsonplayback.player.hibernate;

import java.util.Map;
import java.util.Stack;

import org.hibernate.collection.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;
import org.jsonplayback.player.IPlayerManager;
import org.jsonplayback.player.IdentityRefKey;
import org.jsonplayback.player.PlayerMetadatas;
import org.jsonplayback.player.SignatureBean;

public interface IPlayerManagerImplementor extends IPlayerManager {
	SignatureBean generateLazySignature(PersistentCollection persistentCollection);

	SignatureBean generateLazySignature(HibernateProxy hibernateProxy);

	SignatureBean generateSignature(Object nonHibernateProxy);

	boolean isRelationship(Class<?> clazz, String fieldName);
	
	Long getCurrId();

	Map<Long, Object> getObjectByIdMap();

	/**
	 * Internal use.
	 * @return
	 */
	Map<IdentityRefKey, Long> getIdByObjectMap();
	
	void currIdPlusPlus();
	
	SignatureBean generateLazySignatureForCollRelashionship(Class<?> ownerClass, String fieldName, Object ownerValue,
			Object fieldValue);
	
	boolean isComponent(Class<?> componentClass);
	
	boolean isPersistentClass(Class clazz);

	Stack<JsHbBeanPropertyWriter> getJsHbBeanPropertyWriterStepStack();

//	Stack<String> getCurrentCompositePathStack();
//	Object getCurrentCompositeOwner();
	
	AssociationAndComponentTrackInfo getCurrentAssociationAndComponentTrackInfo();

	String getPlayerObjectIdName(Class clazz);

	Stack<JsHbJsonSerializer> getJsHbJsonSerializerStepStack();
	
	SignatureBean generateComponentSignature(AssociationAndComponentTrackInfo entityAndComponentTrackInfo);

	Stack<PlayerMetadatas> getJsHbBackendMetadatasWritingStack();

	SignatureBean generateLazySignatureForJsHbLazyProperty(Class<?> ownerClass, String fieldName, Object ownerValue,
			Object fieldValue);
	
	String getCurrentPathFromLastEntity();

	boolean isCurrentPathFromLastEntityAnEntityRelationship();

	Map<IdentityRefKey, PlayerMetadatas> getMetadatasCacheMap();
}