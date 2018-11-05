class OfficeBetter{
	public static void main(String args []){
		try{
			//动态加载类，在运行时加载
			Class c = Class.forName(args[0]);
			
			OfficeAble oa = (OfficeAble)c.newInstance();
			oa.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}