package shihuo.model;

import java.util.List;

public class GoodsModel {
	public int status;
	public String msg;
	public DataModel data;
	
	public  class DataModel{
		public SupplierInfoModel supplier_info;
	}
	
	public class SupplierInfoModel{
		public String num;
		public List<ListModel> list;
	}
	
	public class ListModel{
		public String title;
		public SkuInfoDetailModel skuInfoDetail;
	}
	
	public class SkuInfoDetailModel{
		public List<AttrModel> attr;
	}
	
	public class AttrModel{
		public String price;
		public AttrValueModel value;
	}
	
	public class AttrValueModel{
		public String color;
		public String size;
	}
}


