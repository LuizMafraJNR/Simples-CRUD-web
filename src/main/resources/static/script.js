(function(){
    // Para mostrar o botão que foi clicado
    $("#tabclientes").on("click",".js-delete", function(){
        // Para indetificarmos o botão que foi clicado
        let botaoClicado  = $(this);
        // Falos para o jquery pesquisar o botão chamado btnsim, e depois modificar o dom(html)
        // dinamicamente e atribuir um valor.
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        // Para mostrar o nosso modal (aquela telinha do bootstrap)
        $("#modalcliente").modal("show");
    });

    // Vamos abrir outro call back - jquery procura o btnsim, se achar adicionar um evento de click.
    $("#btnsim").on("click",function(){
        // para pegar a refencia do botão
        let botaoSim = $(this);
        // para pegar a refencia do id do cliente que foi clicado
        let id = botaoSim.attr("data-id");
        // Fazer uma chamada (backend)
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                // depois de ter concluido, vai mandar o navegador para:
                window.location.href="/clientes";
            }
        });
    });


})();