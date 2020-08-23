package br.com.sisbio.tela.controlador;

import br.com.sisbio.tela.TelaPrincipal;
import br.com.sisbio.cadastramento.api.Usuario;
import br.com.sisbio.cadastramento.api.service.UsuarioServico;
//import br.com.bg.sgfapm.utilitarios.Conexao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorTelaLogin {

    private JFrame telaLogin;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JButton btnLogin;
    private Usuario usuario;

    private UsuarioServico usuarioServico;

    public ControladorTelaLogin(JFrame tela, JTextField txtUsuario, JTextField txtSenha, JButton btnLogin, UsuarioServico usuarioServico) {
        this.telaLogin = tela;
        this.txtUsuario = txtUsuario;
        this.txtSenha = txtSenha;
        this.btnLogin = btnLogin;

        this.txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferirFoco((JComponent) e.getSource());
            }
        });
        this.txtSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
        this.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });

        //checarConexao();
        this.usuarioServico = usuarioServico;
    }

//    private void checarConexao() {
//        try (Connection conexao = new Conexao().getConnection()) {
//            if (conexao != null) {
//                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//                        "/br/com/bg/sgfapm/icones/db-ok.png")));
//                lblStatus.setToolTipText("Status de conexão: Conectado");
//            } else {
//                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//                        "/br/com/bg/sgfapm/icones/db-error.png")));
//                lblStatus.setToolTipText("Status de conexão: Não conectado");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ControladorTelaLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void transferirFoco(JComponent campo) {
        campo.transferFocus();
    }

    private boolean camposPreenchidos() {
        return !(txtUsuario.getText().isEmpty() || txtSenha.getText().isEmpty());
    }

    private void logar() {
        if (camposPreenchidos()) {
            if (usuarioCadastrado()) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.lblUsuario.setText(usuario.getNome());
                if (usuario.getPerfil().equals("admin")) {
                    TelaPrincipal.menuRelatorio.setEnabled(true);
                    TelaPrincipal.menuCadastroUsuario.setEnabled(true);
                    principal.lblUsuario.setText(usuario.getNome());
                    principal.lblUsuario.setForeground(Color.red);
                } else {
                    TelaPrincipal.menuRelatorio.setEnabled(false);
                    TelaPrincipal.menuCadastroUsuario.setEnabled(false);
                }
                principal.setVisible(true);
                telaLogin.setVisible(false);

                txtUsuario.setText("");
                txtSenha.setText("");

                principal.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        telaLogin.setVisible(true);
                        txtUsuario.grabFocus();
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                txtSenha.selectAll();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos");
            txtUsuario.requestFocus();
        }
    }

    private boolean usuarioCadastrado() {
        usuario = usuarioServico.autenticar(txtUsuario.getText(), txtSenha.getText());
        return usuario != null;
    }

    private void fechar() {
        telaLogin.setVisible(false);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
    }
}
