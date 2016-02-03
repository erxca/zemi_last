package makeDeck;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;

class BtnAction extends AbstractAction {

      private JComboBox cmb;

      BtnAction(JComboBox cmb) {
            super("デッキ作成");
            this.cmb = cmb;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            Object message = cmb.getSelectedItem();//ここでコンボボックスの中身を取得しています。
            System.out.println(message);
            try {
				MakeDeck.Calc2((String) message);
			} catch (IOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
            //以下で取得した値を表示しています。
//            JOptionPane.showMessageDialog(null, message, "コンボボックスで選択されている項目", JOptionPane.INFORMATION_MESSAGE);
      }

}