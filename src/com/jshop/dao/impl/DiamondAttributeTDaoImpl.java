package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.DiamondAttributeTDao;
import com.jshop.entity.DiamondAttributeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * DiamondAttributeT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.DiamondAttributeT
 * @author MyEclipse Persistence Tools
 */
@Repository("diamondAttributeTDao")
public class DiamondAttributeTDaoImpl extends HibernateDaoSupport implements DiamondAttributeTDao {

	private static final Logger log = LoggerFactory.getLogger(DiamondAttributeTDaoImpl.class);

	public int addDiamondAttributeT(DiamondAttributeT gat) {
		log.info("save DiamondAttributeT");
		try {
			this.getHibernateTemplate().save(gat);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public List<DiamondAttributeT> findDiamondAttributeTByName(String diamondname) {
		log.debug("find by id DiamondAttributeT");
		try {
			String queryString = "from DiamondAttributeT as dat where dat.attname=:attname";
			@SuppressWarnings("unchecked")
			List<DiamondAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "attname", diamondname);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id DiamondAttributeT error", re);
			throw re;
		}
	}

	public int updateDiamondAttributeT(final DiamondAttributeT gat) {
		log.debug("update DiamondAttributeT");
		try {

			//			final String queryString = "update DiamondAttributeT as gat set gat.goodsattributename=:goodsattributename,gat.goodsTypeId=:goodsTypeId,gat.goodsTypeName=:goodsTypeName,gat.createtime=:createtime,gat.creatorid=:creatorid,gat.state=:state,gat.attributeType=:attributeType,gat.attributelist=:attributelist,gat.sort=:sort,gat.attributeIndex=:attributeIndex where gat.goodsattributeid=:goodsattributeid ";
			//			this.getHibernateTemplate().execute(new HibernateCallback() {
			//
			//				public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//					int i = 0;
			//					Query query = session.createQuery(queryString);
			//					query.setParameter("goodsattributeid", gat.getDiamondattributeid());
			//					query.setParameter("goodsattributename", gat.getDiamondattributename());
			//					query.setParameter("goodsTypeId", gat.getDiamondTypeId());
			//					query.setParameter("goodsTypeName", gat.getDiamondTypeName());
			//					query.setParameter("createtime", gat.getCreatetime());
			//					query.setParameter("state", gat.getState());
			//					query.setParameter("creatorid", gat.getCreatorid());
			//					query.setParameter("attributeType", gat.getAttributeType());
			//					query.setParameter("attributelist", gat.getAttributelist());
			//					query.setParameter("sort", gat.getSort());
			//					query.setParameter("attributeIndex", gat.getAttributeIndex());
			//					i = query.executeUpdate();
			//					return i;
			//				}
			//			});
		} catch (RuntimeException re) {
			log.error("update  DiamondAttributeT error", re);
			throw re;
		}
		return 0;
	}

	public long countfindAllDiamondAttributeT() {
		log.debug("count all DiamondAttributeT");
		try {
			String queryString = "select count(*) from DiamondAttributeT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list!=null&&list.size() > 0) {
				long l = (Long)list.get(0);
				return  l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all DiamondAttributeT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondAttributeT> findAllDiamondAttributeT(final int currentPage, final int lineSize) {
		log.debug("find all DiamondAttributeT");
		try {
			List<DiamondAttributeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString = "from DiamondAttributeT  order by createtime desc";
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List<DiamondAttributeT> list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("find all DiamondAttributeT error", re);
			throw re;
		}
	}

	public int delDiamondAttributeT(final String[] list) {
		log.debug("del DelDiamondAttributeT");
		try {

			final String queryString = "delete from DiamondAttributeT as gat where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsattributeid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del DelDiamondAttributeT failed", re);
			throw re;
		}
		return 0;
	}

	public List<DiamondAttributeT> findDiamondAttributeTByDiamondTypeName(String goodsTypeName) {
		log.debug("find by id findDiamondAttributeTByDiamondTypeName");
		try {
			String queryString = "from DiamondAttributeT as gat where gat.goodsTypeName=:goodsTypeName";
			List<DiamondAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeName", goodsTypeName);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findDiamondAttributeTByDiamondTypeName error", re);
			throw re;
		}
	}

	public List<DiamondAttributeT> findDiamondAttributeTBygoodsTypeId(String goodsTypeId) {
		log.debug("find by id findDiamondAttributeTBygoodsTypeId");
		try {
			String queryString = "from DiamondAttributeT as gat where gat.goodsTypeId=:goodsTypeId";
			List<DiamondAttributeT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsTypeId", goodsTypeId);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id findDiamondAttributeTBygoodsTypeId error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondAttributeT> sortAllDiamondAttributeT(final int currentPage, final int lineSize, final String queryString) {
		log.debug("find all DiamondAttributeT");
		try {
			List<DiamondAttributeT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondAttributeT error", re);
			throw re;
		}
	}

	public int updateDiamondAttributeTgoodsTypeName(final String goodsTypeName, final String goodsTypeId) {
		log.debug("updateDiamondAttributeTgoodsTypeName");
		try {
			final String queryString = "update DiamondAttributeT as gat set gat.goodsTypeName=:goodsTypeName where gat.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsTypeName", goodsTypeName);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondAttributeTgoodsTypeName error", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondAttributeissametolinkBygoodsattributeid(final String[] goodsattributeid, final String issametolink) {
		log.debug("updateDiamondAttributeissametolinkBygoodsattributeid");
		try {
			final String queryString = "update DiamondAttributeT as gat set gat.issametolink=:issametolink where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsattributeid) {
						query.setParameter("goodsattributeid", s);
						query.setParameter("issametolink", issametolink);
						i = query.executeUpdate();
						i++;
					}
					if (goodsattributeid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondAttributeissametolinkBygoodsattributeid error", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondAttributeissearchBygoodsattributeid(final String[] goodsattributeid, final String issearch) {
		log.debug("updateDiamondAttributeissearchBygoodsattributeid");
		try {
			final String queryString = "update DiamondAttributeT as gat set gat.issearch=:issearch where gat.goodsattributeid=:goodsattributeid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsattributeid) {
						query.setParameter("goodsattributeid", s);
						query.setParameter("issearch", issearch);
						i = query.executeUpdate();
						i++;
					}
					if (goodsattributeid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondAttributeissearchBygoodsattributeid error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public List<DiamondAttributeT> findDiamondAttibuteByType() {
		log.info("find by type DiamondAttributeT");
		try {
			String queryString = "from DiamondAttributeT as dat where dat.fid=0";
			@SuppressWarnings("unchecked")
			List<DiamondAttributeT> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find by id DiamondAttributeT error", re);
			throw re;
		}
	}




}