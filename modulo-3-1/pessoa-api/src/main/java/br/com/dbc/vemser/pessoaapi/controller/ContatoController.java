//package br.com.dbc.vemser.pessoaapi.controller;
//
//
//import br.com.dbc.vemser.pessoaapi.entity.Contato;
//import br.com.dbc.vemser.pessoaapi.service.ContatoService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/contato")
//public class ContatoController {
//
// erro  ao importar Service
// ----------- erro na parte API/http tirar duvida aula --------
//    private ContatoService contatoService;
//
//    public ContatoController() {
//        contatoService = new ContatoService();
//    }
//
//    @GetMapping
//    public List<Contato> list() {
//        return contatoService.list();
//    }
//
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<Contato> listar(@PathVariable("idPessoa") Integer idPessoa){
//
//        return contatoService.listar(idPessoa);
//    }
//
//    @PostMapping("/{idPessoa}")
//    public Contato create(@PathVariable("idPessoa"), @RequestBody Contato contato) {
//
//        return contatoService.create(contato);
//    }
//
//    @PutMapping("/{idContato}")
//    public Contato update(@PathVariable("idContato") Integer id,
//                         @RequestBody Contato contatoAtualizar) throws Exception {
//        return contatoService.update(id, contatoAtualizar);
//    }
//
//    @DeleteMapping("/{idContato}")
//    public void delete(@PathVariable("idContato") Integer id) throws Exception {
//        contatoService.delete(id);
//    }
//}
