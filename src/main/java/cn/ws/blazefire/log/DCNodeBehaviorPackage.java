package cn.ws.blazefire.log;

/**
 * 包活跃信息节点
 * 
 * @author Vinnes
 * 
 */
public class DCNodeBehaviorPackage
{
	// 行为类型
	// 0 - 安装嗅探
	// 1 - 用户主动进入
	// 2 - 帐号登入进入
	private int type;

	// 用户ID
	private int uid;

	// 包ID
	private int pkid;

	// 包版本
	private int pkvid;

	// // 客户端时间
	// private long time;

	//国家类型
	private int countryType;

	public int getCountryType()
	{
		return countryType;
	}

	public void setCountryType(int countryType)
	{
		this.countryType = countryType;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uid)
	{
		this.uid = uid;
	}

	public int getPkid()
	{
		return pkid;
	}

	public void setPkid(int pkid)
	{
		this.pkid = pkid;
	}

	public int getPkvid()
	{
		return pkvid;
	}

	public void setPkvid(int pkvid)
	{
		this.pkvid = pkvid;
	}

	// public int getTime()
	// {
	// 	return time;
	// }
	//
	// public void setTime(int time)
	// {
	// 	this.time = time;
	// }
}
