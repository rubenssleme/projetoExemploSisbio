
using Microsoft.VisualStudio.TestTools.UnitTesting;
using projetoAgendaDeContatos.dominio;

namespace projetoAgendaDeContatos.repositorio
{
    [TestClass]
  public  class TesteRepositorioContato
    {

        [TestMethod]
        public void TestSalvarContato()
        {
            Contato contato = new Contato();
            RepositorioContato repositorioContato = new RepositorioContato();

            contato._nome = "Rubens Leme";
            contato._endereco = "Rua sem saida";
            contato._eMail = "rubens@";
            contato._telefone = "123";

            
            repositorioContato.Incluir(contato);
        }

    }
}
