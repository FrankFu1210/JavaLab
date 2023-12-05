package tw.frank.classes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable{
	public MyTable() {
		
		//mymodel方便存取fooddb	
		
	}
	
	//內部類別，方便存取外部類別屬性方法
	//找不抽象的當父類別，好處更多彈性運用，DefaultTableModel發揚光大抽象類別功能更強大
	//extends就是要override
	private class MyModel extends DefaultTableModel{

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return super.getRowCount();//問物件就對了
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return super.getColumnCount();//問物件就對了
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return super.getValueAt(row, column);
		}

//		@Override //等data進來使用
//		public void setValueAt(Object aValue, int row, int column) {
//			// TODO Auto-generated method stub
//			super.setValueAt(aValue, row, column);
//		}
		
	}
}
//資料庫要登場了

//DefaultTable父類別有欄位標題此招，不用override改寫他
//有功能就不用override了，呼叫就好 mymodel.setColumnIdentifiers
//再寫一個類別，用下方字串陣列return去呼叫

//增刪修
//點的過程中游標指標移過去，有觸發到他型為

//資料欄位修改aaa，原資料異動不用repaint

//HW: rs insert row 新增
//資料表movetoinsertrow在資料表上，但畫面沒有
//視覺上table先新增新列，然後指標移過去在連結

//Spring 12 13 14章
//初學不要看~
