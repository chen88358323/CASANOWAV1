package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jshop.dao.DiamondTDao;
import com.jshop.entity.DiamondT;

/**
 * A data access object (DAO) providing persistence and search support for
 * DiamondT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.DiamondT
 * @author MyEclipse Persistence Tools
 */
//@Component("diamondTDao")
@Repository("diamondTDao")
public class DiamondTDaoImpl extends HibernateDaoSupport implements DiamondTDao {

	private static final Log log = LogFactory.getLog(DiamondTDaoImpl.class);
	//增加钻石商品
	public int addDiamond(DiamondT g) {
		log.info("save diamondT");
		try {
			this.getHibernateTemplate().save(g);
			log.info("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countAllDiamond(Date creatorid) {
		log.info("count all DiamondT");
		try {
			String queryString = "select count(1) from DiamondT as gt  where gt.creatorid>:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "createtime", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all DiamondT error", re);
			throw re;
		}
	}

	public int delDiamond(final String[] list, final String creatorid) {
		log.info("del DiamondT");
		try {

			final String queryString = "delete from DiamondT as gt where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("goodsid", s);
						query.setParameter("creatorid", creatorid);
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
			log.error("del DiamondT failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findAllDiamond(final int currentPage, final int lineSize, final String creatorid) {
		log.info("find all DiamondT");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString = "from DiamondT as gt order by createtime desc";
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("createtime", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> sortAllDiamond(final int currentPage, final int lineSize, final String creatorid, final String queryString) {
		log.info("sortAllDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;

				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("sortAllDiamond error", re);
			throw re;

		}
	}

	@SuppressWarnings("unchecked")
	public DiamondT findDiamondById(String goodsid) {
		log.info("find by id DiamondT");
		try {
			String queryString = "from DiamondT as gt where gt.goodsid=:goodsid";
			List<DiamondT> list = this.getHibernateTemplate().findByNamedParam(queryString, "goodsid", goodsid);
			if(!list.isEmpty()){
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id DiamondT error", re);
			throw re;
		}
	}

	public List<DiamondT> findDiamondBybrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondByDiamondname(final int currentPage, final int lineSize, final String goodsname) {
		log.info("find all DiamondT by goodsname");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as g where g.goodsname like ? order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter(0, "%" + goodsname + "%");
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondT by goodname error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondByKeyword(final String keywordid, final int currentPage, final int lineSize) {
		log.info("find all findDiamondByKeyword");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1'and gt.keywordid=:keywordid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("keywordid", keywordid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findDiamondByKeyword error", re);
			throw re;
		}
	}

	public int countfindDiamondByKeyword(String keywordid) {
		log.info("count all countfindDiamondByKeyword");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1' and gt.keywordid=:keywordid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "keywordid", keywordid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindDiamondByKeyword error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondByLtypeid(final String ltypeid, final String salestate, final int currentPage, final int lineSize) {
		log.info("find all findDiamondByLtypeid");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.ltypeid=:ltypeid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("ltypeid", ltypeid);
					query.setParameter("salestate", salestate);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findDiamondByLtypeid error", re);
			throw re;
		}
	}

	public int countfindDiamondByLtypeid(String ltypeid, String salestate) {
		log.info("count all countfindDiamondByLtypeid");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate=:salestate and gt.ltypeid=:ltypeid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "salestate", "ltypeid" }, new Object[] { salestate, ltypeid });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindDiamondByLtypeid error", re);
			throw re;
		}
	}

	public List<DiamondT> findDiamondBymodel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiamondT> findDiamondByNavid(final String navid, final String salestate, final int currentPage, final int lineSize) {
		log.info("find all findDiamondByLtypeid");
		try {
			@SuppressWarnings("unchecked")
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.navid=:navid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("navid", navid);
					query.setParameter("salestate", salestate);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findDiamondByLtypeid error", re);
			throw re;
		}
	}

	public int countfindDiamondByNavid(String navid, String salestate) {
		log.info("count all countfindDiamondByNavid");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate=:salestate and gt.navid=:navid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "salestate", "navid" }, new Object[] { salestate, navid });
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindDiamondByNavid error", re);
			throw re;
		}
	}

	public List<DiamondT> findDiamondByprice(String price) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiamondT> findDiamondByStypeid(String stypeid, String salestate) {
		log.info("findDiamondByStypeid");
		try {
			String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.stypeid=:stypeid";
			List<DiamondT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "salestate", "stypeid" }, new Object[] { salestate, stypeid });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findDiamondByStypeid error", re);
			throw re;
		}
	}

	public List<DiamondT> findDiamondByusersetnum(String usersetnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateDiamond(final DiamondT g) {
		log.info("update DiamondT");
		try {
			this.getHibernateTemplate().update(g);
			return 1;
		} catch (RuntimeException re) {
			log.error("update  updateDiamond error", re);
			throw re;
		}
	}

	public int updateDiamondbargainprice(final String[] goodsid, final String bargainprice, final String creatorid) {
		log.info("update updateDiamondbargainprice");
		try {

			final String queryString = "update DiamondT as gt set gt.bargainprice=:bargainprice where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("bargainprice", bargainprice);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update updateDiamondbargainprice failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondhotsale(final String[] goodsid, final String hotsale, final String creatorid) {
		log.info("updateDiamondhotsale");
		try {

			final String queryString = "update DiamondT as gt set gt.hotsale=:hotsale where gt.goodsid=:goodsid where gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("hotsale", hotsale);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondhotsale failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondreadcount(final String goodsid) {
		log.info("update DiamondT readcount");
		try {
			final String queryString = "update DiamondT as gt set gt.readcount=readcount+1 where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  DiamondT readcount error", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondrecommended(final String[] goodsid, final String recommended, final String creatorid) {
		log.info("update updateDiamondrecommended");
		try {

			final String queryString = "update DiamondT as gt set gt.recommended=:recommended where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("recommended", recommended);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateDiamondrecommended failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondisNew(final String[] goodsid, final String isNew, final String creatorid) {
		log.info("updateDiamondisNew");
		try {

			final String queryString = "update DiamondT as gt set gt.isNew=:isNew where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("isNew", isNew);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondisNew failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondismobileplatformgoods(final String[] goodsid, final String ismobileplatformgoods, final String creatorid) {
		log.info("updateDiamondismobileplatformgoods");
		try {

			final String queryString = "update DiamondT as gt set gt.ismobileplatformgoods=:ismobileplatformgoods where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("ismobileplatformgoods", ismobileplatformgoods);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondismobileplatformgoods failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondrelatedfit(String goodsid, String list) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDiamondrelatedgoods(final String goodsid, final String list) {
		log.info("update DiamondT RELATEDGOODSID");
		try {
			final String queryString = "update DiamondT as gt set gt.relatedgoodsid=:relatedgoodsid where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("relatedgoodsid", list);

					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  DiamondT RELATEDGOODSID error", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondreplycount(String goodsid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDiamondSaleState(final String[] goodsid, final String salestate, final String creatorid) {
		log.info("update UpdateDiamondSaleState");
		try {

			final String queryString = "update DiamondT as gt set gt.salestate=:salestate where gt.goodsid=:goodsid and gt.creatorid=:creatorid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("salestate", salestate);
						query.setParameter("creatorid", creatorid);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateDiamondSaleState failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondSaleState(final String goodsTypeId, final String salestate) {
		log.info("update UpdateDiamondSaleState");
		try {
			final String queryString = "update DiamondT as gt set gt.salestate=:salestate where gt.goodsTypeId=:goodsTypeId";
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					query.setParameter("salestate", salestate);
					query.setParameter("goodsTypeId", goodsTypeId);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update UpdateDiamondSaleState failed", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondsortid(String goodsid, String goodsortid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDiamondsortname(String goodsid, String goodssortname) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSort(String goodsid, Integer sort) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateFiveDiamondState(final String[] goodsid, final String recommended, final String hotsale, final String bargainprice, final String isNew, final String ismobileplatformgoods) {
		log.info("updateFiveDiamondState");
		try {

			final String queryString = "update DiamondT as gt set gt.bargainprice=:bargainprice,gt.recommended=:recommended,gt.hotsale=:hotsale,gt.isNew=:isNew,gt.ismobileplatformgoods=:ismobileplatformgoods where gt.goodsid=:goodsid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : goodsid) {
						query.setParameter("goodsid", s);
						query.setParameter("bargainprice", bargainprice);
						query.setParameter("recommended", recommended);
						query.setParameter("hotsale", hotsale);
						query.setParameter("isNew", isNew);
						query.setParameter("ismobileplatformgoods", ismobileplatformgoods);
						i = query.executeUpdate();
						i++;
					}
					if (goodsid.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("updateFiveDiamondState failed", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondForoptiontransferselect(final String navid, final String ltypeid, final String stypeid, final String goodsname) {
		log.info("find all DiamondT");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT  as gt where gt.salestate='1' and gt.navid=:navid and gt.ltypeid=:ltypeid and gt.stypeid=:stypeid and gt.goodsname like :goodsname order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("navid", navid);
					query.setParameter("ltypeid", ltypeid);
					query.setParameter("stypeid", stypeid);
					query.setParameter("goodsname", "%" + goodsname + "%");
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondT error", re);
			throw re;
		}
	}

	public List<DiamondT> findAllDiamondtWithoutSplitpage() {
		log.info(" all DiamondT");
		try {
			String queryString = "from DiamondT as gt where gt.salestate='1'";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" all DiamondT error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondLimitByDiamondType(final String nlstypeid, final int limit) {
		log.info("find all DiamondT nlstypeid��limit");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT  as gt where gt.salestate='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid  order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(limit);
					query.setParameter("nlstypeid", nlstypeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondT nlstypeid��limit", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findSamepriceDiamond(final int limit, final double minprice, final double maxprice, final String goodsid) {
		log.info("find all DiamondT Sameprice��limit");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT  as gt where gt.memberprice between :minprice and :maxprice and gt.goodsid!=:goodsid and gt.salestate='1' order by createtime desc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setMaxResults(limit);
					query.setParameter("minprice", minprice);
					query.setParameter("maxprice", maxprice);
					query.setParameter("goodsid", goodsid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all DiamondT Sameprice��limit", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findMoreDiamondByDiamondType(final String nlstypeid, final int currentPage, final int lineSize) {
		log.info("find all findMoreDiamondByDiamondTyp");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("nlstypeid", nlstypeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find allfindMoreDiamondByDiamondType error", re);
			throw re;
		}
	}

	public int countfindMoreDiamondByDiamondType(String nlstypeid) {
		log.info("count all countfindMoreDiamondByDiamondType");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreDiamondByDiamondType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public int countfindSearchDiamond(final String goodsname) {
		log.info("find all findSearchDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1'and gt.goodsname like ? order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter(0, "%" + goodsname + "%");
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				int i = list.size();
				return i;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("find findSearchDiamond error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findSearchDiamond(final String goodsname, final int currentPage, final int lineSize) {
		log.info("find all findSearchDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1'and gt.goodsname like ? order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter(0, "%" + goodsname + "%");
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findSearchDiamond error", re);
			throw re;
		}
	}

	public int countfindAllDiamondlistMore(String salestate) {
		log.info("count all countfindAllDiamondlistMore");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "salestate", salestate);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllDiamondlistMore error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findAllDiamondlistMore(final int currentPage, final int lineSize, final String salestate) {
		log.info("find all findSearchDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate=:salestate order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("salestate", salestate);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findSearchDiamond error", re);
			throw re;
		}
	}

	public int countfindMoreBargainPriceDiamond() {
		log.info("count all countfindMoreBargainPriceDiamond");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1' and gt.bargainprice='1'";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreBargainPriceDiamond error", re);
			throw re;
		}
	}

	public int countfindMoreBargainPriceDiamondByDiamondType(String nlstypeid) {
		log.info("count all countfindMoreBargainPriceDiamondByDiamondType");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1'and gt.bargainprice='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreBargainPriceDiamondByDiamondType error", re);
			throw re;
		}
	}

	public int countfindMoreHotSaleDiamondByDiamondType(String nlstypeid) {
		log.info("count all countfindMoreHotSaleDiamondByDiamondType");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1'and gt.hotsale='1'and  gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreHotSaleDiamondByDiamondType error", re);
			throw re;
		}
	}

	public int countfindMoreRecommendedDiamondByDiamondType(String nlstypeid) {
		log.info("count all countfindMoreRecommendedDiamondByDiamondType");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1'and gt.recommended='1'and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "nlstypeid", nlstypeid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindMoreRecommendedDiamondByDiamondType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findMoreBargainPriceDiamond(final int currentPage, final int lineSize) {
		log.info("find all findMoreBargainPriceDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1' and gt.bargainprice='1' order by createtime asc";

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
			log.error("find findMoreBargainPriceDiamond error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findMoreBargainPriceDiamondByDiamondType(final String nlstypeid, final int currentPage, final int lineSize) {
		log.info("find all findMoreBargainPriceDiamondByDiamondType");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1' and gt.bargainprice='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("nlstypeid", nlstypeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreBargainPriceDiamondByDiamondType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findMoreHotSaleDiamondByDiamondType(final String nlstypeid, final int currentPage, final int lineSize) {
		log.info("find all findMoreHotSaleDiamondByDiamondType");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1' and gt.hotsale='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("nlstypeid", nlstypeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreHotSaleDiamondByDiamondType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findMoreRecommendedDiamondByDiamondType(final String nlstypeid, final int currentPage, final int lineSize) {
		log.info("find all findMoreHotSaleDiamondByDiamondType");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1' and gt.recommended='1' and gt.navid=:nlstypeid or gt.ltypeid=:nlstypeid or gt.stypeid=:nlstypeid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("nlstypeid", nlstypeid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find findMoreHotSaleDiamondByDiamondType error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findAllDiamondByismobileplatformgoods(final int currentPage, final int lineSize, final String creatorid) {
		log.info("findAllDiamondByismobileplatformgoods");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate='1' and gt.ismobileplatformgoods='1' and gt.creatorid=:creatorid order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("creatorid", creatorid);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findAllDiamondByismobileplatformgoods error", re);
			throw re;
		}
	}


	@Override
	public List<DiamondT> findAllDiamondByismobileplatformgoodsBynavid(
			final String navid, final String salestate, final String ismobileplatformgoods) {
		log.info("findAllDiamondByismobileplatformgoods");
		try {
			@SuppressWarnings("unchecked")
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.ismobileplatformgoods=:ismobileplatformgoods and gt.navid=:navid order by createtime asc";
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setParameter("navid", navid);
					query.setParameter("ismobileplatformgoods", ismobileplatformgoods);
					query.setParameter("salestate", salestate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findAllDiamondByismobileplatformgoods error", re);
			throw re;
		}
	}

	public int countfindAllDiamondByismobileplatformgoods(String creatorid) {
		log.info("count all countfindAllDiamondByismobileplatformgoods");
		try {
			String queryString = "select count(*) from DiamondT as gt where gt.salestate='1'and gt.ismobileplatformgoods='1' and gt.creatorid=:creatorid";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "creatorid", creatorid);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all countfindAllDiamondByismobileplatformgoods error", re);
			throw re;
		}
	}

	public List<DiamondT> findAllDiamondForImgT() {
		log.info(" all DiamondT");
		try {
			String queryString = "from DiamondT";
			List list = this.getHibernateTemplate().find(queryString);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" all DiamondT error", re);
			throw re;
		}
	}

	public List<DiamondT> findAllDiamondBynavid(String navid, String salestate) {
		log.info("findAllDiamondBynavid");
		try {
			String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate";
			List<DiamondT> list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate" }, new Object[] { navid, salestate });
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllDiamondBynaviderror", re);
			throw re;
		}
	}

	public List<DiamondT> findDiamondByLtypeid(String ltypeid, String salestate) {
		log.info("findDiamondByLtypeid");
		try {
			String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate" }, new Object[] { ltypeid, salestate });
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" findDiamondByLtypeid", re);
			throw re;
		}
	}

	public int updateHtmlPath(final String goodsid, final String htmlPath) {
		log.info("updateHtmlPath");
		try {

			final String queryString = "update DiamondT as gt set gt.htmlPath=:htmlPath where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("htmlPath", htmlPath);

					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	@Override
	public int updateHtmlPath(final String goodsid, final String htmlPath, final Date updatetime) {
		log.info("updateHtmlPath");
		try {

			final String queryString = "update DiamondT as gt set gt.htmlPath=:htmlPath, gt.updatetime=:updatetime where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", goodsid);
					query.setParameter("htmlPath", htmlPath);
					query.setParameter("updatetime", updatetime);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateHtmlPath error", re);
			throw re;
		}
		return 0;
	}

	public List<DiamondT> finaAllDiamondT(String salestate) {
		log.info("finaAllDiamondT");
		try {
			String queryString = "from DiamondT as gt where gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, "salestate", salestate);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" finaAllDiamondT", re);
			throw re;
		}
	}

	public int updatecommentsumBygoodsid(final String goodsid, final int totalcomment) {
		log.info("updatetotalcomment");
		try {

			final String queryString = "update DiamondT as gt set gt.totalcomment=:totalcomment  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("totalcomment", totalcomment);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatecommentsum error", re);
			throw re;
		}
		return 0;
	}

	public int updatestarsumBygoodsid(final String goodsid, final int star) {
		log.info("updatestarsumBygoodsid");
		try {

			final String queryString = "update DiamondT as gt set gt.star=:star  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("star", star);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();

					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatestarsumBygoodsid error", re);
			throw re;
		}
		return 0;
	}

	public int updatestarusersumBygoodsid(final String goodsid, final int staruser) {
		log.info("updatestarusersum");
		try {

			final String queryString = "update DiamondT as gt set gt.staruser=:staruser  where gt.goodsid=:goodsid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("staruser", staruser);
					query.setParameter("goodsid", goodsid);
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updatestarusersum error", re);
			throw re;
		}
		return 0;
	}

	public List<DiamondT> findAllDiamondBynavidorderbyParams(String navid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value) {
		log.info("findAllDiamondBynavidorderbyParams");
		try {
			if (sales != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate order by sales asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate" }, new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (memberprice != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate order by memberprice asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate" }, new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (totalcomment != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate order by totalcomment asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate" }, new Object[] { navid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (bargainprice != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.bargainprice=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate", "value" }, new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (hotsale != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.hotsale=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate", "value" }, new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;

			}
			if (recommended != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.recommended=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate", "value" }, new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (isNew != null) {
				String queryString = "from DiamondT as gt where gt.navid=:navid and gt.salestate=:salestate and gt.isNew=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "navid", "salestate", "value" }, new Object[] { navid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			return null;
		} catch (RuntimeException re) {
			log.error(" findAllDiamondBynavidorderbyParams", re);
			throw re;
		}
	}

	public List<DiamondT> findAllDiamondByLtypeidorderbyParams(String ltypeid, String salestate, String sales, String memberprice, String totalcomment, String bargainprice, String hotsale, String recommended, String isNew, String value) {
		log.info("findDiamondByLtypeidorderbyParams");
		try {
			if (sales != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by sales asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate" }, new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (memberprice != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by memberprice asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate" }, new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (totalcomment != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate order by totalcomment asc";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate" }, new Object[] { ltypeid, salestate });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (bargainprice != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.bargainprice=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate", "value" }, new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (hotsale != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.hotsale=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate", "value" }, new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;

			}
			if (recommended != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.recommended=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate", "value" }, new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			if (isNew != null) {
				String queryString = "from DiamondT as gt where gt.ltypeid=:ltypeid and gt.salestate=:salestate and gt.isNew=:value";
				List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[] { "ltypeid", "salestate", "value" }, new Object[] { ltypeid, salestate, value });
				if (list != null && list.size() > 0) {
					return list;
				}
				return null;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("findDiamondByLtypeidorderbyParams", re);
			throw re;
		}

	}

	public int updateDiamondTypeNameBygoodsTypeId(final String goodsTypeName, final String goodsTypeId) {
		log.info("updateDiamondTypeNameBygoodsTypeId");
		try {
			final String queryString = "update DiamondT as gt set gt.goodsTypeName=:goodsTypeName  where gt.goodsTypeId=:goodsTypeId ";
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
			log.error("updateDiamondTypeNameBygoodsTypeId error", re);
			throw re;
		}
		return 0;
	}

	public int updateDiamondCategoryBynlsid(final String queryString) {
		log.info("updateDiamondCategoryBynlsid");
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					i = query.executeUpdate();
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("updateDiamondCategoryBynlsid error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findshuffleDiamond(final int currentPage, final int lineSize, final String salestate, final String recommended) {
		log.info("findshuffleDiamond");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.recommended=:recommended order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("salestate", salestate);
					query.setParameter("recommended", recommended);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findshuffleDiamond error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DiamondT> findDiamondByattrs(final int currentPage, final int lineSize, final String attr, final String salestate) {
		log.info("findDiamondByattrs");
		try {
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from DiamondT as gt where gt.salestate=:salestate and gt.goodsAttrVal0=:attr or gt.goodsAttrVal1=:attr or gt.goodsAttrVal2=:attr or gt.goodsAttrVal3=:attr or gt.goodsAttrVal4=:attr or gt.goodsAttrVal5=:attr or gt.goodsAttrVal6=:attr or gt.goodsAttrVal7=:attr or gt.goodsAttrVal8=:attr or gt.goodsAttrVal9=:attr or gt.goodsAttrVal10=:attr or gt.goodsAttrVal11=:attr or gt.goodsAttrVal12=:attr or gt.goodsAttrVal13=:attr or gt.goodsAttrVal14=:attr or gt.goodsAttrVal15=:attr or gt.goodsAttrVal16=:attr or gt.goodsAttrVal17=:attr or gt.goodsAttrVal18=:attr or gt.goodsAttrVal19=:attr or gt.goodsAttrVal20=:attr or gt.goodsAttrVal21=:attr or gt.goodsAttrVal22=:attr or gt.goodsAttrVal23=:attr or gt.goodsAttrVal24=:attr or gt.goodsAttrVal25=:attr or gt.goodsAttrVal26=:attr or gt.goodsAttrVal27=:attr or gt.goodsAttrVal28=:attr or gt.goodsAttrVal29=:attr  order by createtime asc";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					query.setParameter("attr", attr);
					query.setParameter("salestate", salestate);
					List list = query.list();
					return list;
				}
			});
			return list;
		} catch (RuntimeException re) {
			log.error("findDiamondByattrs error", re);
			throw re;
		}
	}

	@Override
	public List<DiamondT> findDiamondByNavid(String navid, String salestate,
			String ismobileplatformgoods) {
		log.info("findDiamondByNavidforandroid");
		try {
			String queryString = "from DiamondT as gt where gt.navid=:navid and gt.ismobileplatformgoods=:ismobileplatformgoods and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"navid","ismobileplatformgoods","salestate"}, new Object[]{navid,ismobileplatformgoods,salestate});
			return list;
		} catch (RuntimeException re) {
			log.error(" findDiamondByNavidforandroid", re);
			throw re;
		}
	}



	@Override
	public List<DiamondT> findAllDiamondBynavid(String navid, String salestate,
			String isSpecificationsOpen) {
		log.info("findDiamondByNavidforandroid");
		try {
			String queryString = "from DiamondT as gt where gt.navid=:navid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"navid","isSpecificationsOpen","salestate"}, new Object[]{navid,isSpecificationsOpen,salestate});
			return list;
		} catch (RuntimeException re) {
			log.error(" findDiamondByNavidforandroid", re);
			throw re;
		}
	}

	@Override
	public List<DiamondT> findAllDiamondBynavidandltypeid(String navid,
			String ltypeid, String salestate, String isSpecificationsOpen) {
		log.info("findAllDiamondBynavidandltypeid");
		try {
			String queryString = "from DiamondT as gt where gt.navid=:navid and gt.ltypeid=:ltypeid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"navid","ltypeid","isSpecificationsOpen","salestate"}, new Object[]{navid,ltypeid,isSpecificationsOpen,salestate});
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllDiamondBynavidandltypeid error ", re);
			throw re;
		}
	}

	@Override
	public List<DiamondT> findAllDiamondBynavidandltypeidandstypeid(String navid,
			String ltypeid, String stypeid, String salestate,
			String isSpecificationsOpen) {
		log.info("findAllDiamondBynavidandltypeidandstypeid");
		try {
			String queryString = "from DiamondT as gt where gt.navid=:navid and gt.ltypeid=:ltypeid and gt.stypeid=:stypeid and gt.isSpecificationsOpen=:isSpecificationsOpen and gt.salestate=:salestate";
			List list = this.getHibernateTemplate().findByNamedParam(queryString, new String[]{"navid","ltypeid","stypeid","isSpecificationsOpen","salestate"}, new Object[]{navid,ltypeid,stypeid,isSpecificationsOpen,salestate});
			return list;
		} catch (RuntimeException re) {
			log.error(" findAllDiamondBynavidandltypeidandstypeid error ", re);
			throw re;
		}
	}

	@Override
	public List<DiamondT> findAllDiamondByNoTerm() {	

		try {
			final String queryString="from DiamondT";
			@SuppressWarnings("unchecked")
			List<DiamondT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {			
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
					Query query = session.createQuery(queryString);
					List list = query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (RuntimeException e) {
			throw e;
		}

	}

	@Override
	public int batchaddDiamond(String[] list, String creatorid) {
		// TODO Auto-generated method stub
		return 0;
	}






}