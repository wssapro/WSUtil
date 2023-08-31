package cn.ws.tools;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 * @author shun
 * @date 2020-09-24 11:56
 */
public class LibphonenumberUtil
{
	private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	//检测是否为已知用户

	/**
	 * 根据国家代码和手机号  判断手机号是否有效
	 *
	 * @param phoneNumber
	 * @param countryCode
	 * @return
	 */
	public static String getPhoneNumber(String phoneNumber, String countryCode)
	{
		if (phoneNumber == null || "".equals(phoneNumber))
		{
			return null;
		}
		phoneNumber = phoneNumber.replace("+", "");
		phoneNumber = phoneNumber.replaceFirst("^0*", "");
		if (phoneNumber.startsWith(countryCode))
		{
			phoneNumber = phoneNumber.substring(countryCode.length());
		}
		try
		{
			long phone = Long.parseLong(phoneNumber);
			PhoneNumber pn = new PhoneNumber();
			pn.setCountryCode(Integer.parseInt(countryCode));
			pn.setNationalNumber(phone);
			if (phoneNumberUtil.isValidNumber(pn))
			{
				return phoneNumber;
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
