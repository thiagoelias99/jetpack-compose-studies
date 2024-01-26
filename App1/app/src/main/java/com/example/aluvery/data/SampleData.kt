package com.example.aluvery.data

import com.example.aluvery.R
import com.example.aluvery.model.Product
import com.example.aluvery.model.ProductTypesEnum
import java.math.BigDecimal

class SampleData (){
    companion object{
        var productsList = listOf<Product>(
            Product(id = 1, title = "Hamburguer", price = BigDecimal(19.99), description = "Um hambúrguer é um sanduíche composto por um ou mais hambúrgueres de carne, vegetais e condimentos entre pães.", image = R.drawable.burger, type = ProductTypesEnum.FOOD, inPromo = true),
            Product(id = 2, title = "Pizza", price = BigDecimal(44.99), description = "Uma pizza é um prato de massa de formato redondo, coberto com molho de tomate e uma variedade de ingredientes, como queijo, vegetais, carnes e ervas, assada em forno.", image = R.drawable.pizza, type = ProductTypesEnum.FOOD),
            Product(id = 3, title = "Batata Frita", price = BigDecimal(8.99), image = R.drawable.fries, type = ProductTypesEnum.FOOD),
            Product(id = 4, title = "Refrigerante", price = BigDecimal(7.99), image = R.drawable.refrigerante, type = ProductTypesEnum.DRINK, description = "Um refrigerante é uma bebida não alcoólica gaseificada, geralmente adoçada, disponível em uma variedade de sabores, como cola, limão, laranja, etc. É consumido frio e é uma opção popular como refresco"),
            Product(id = 5, title = "Suco", price = BigDecimal(10.99), image = R.drawable.suco, type = ProductTypesEnum.DRINK, description = "Um suco é uma bebida feita a partir da extração do líquido de frutas ou vegetais frescos, sem adição de açúcar, geralmente consumido frio e é uma fonte popular de nutrientes e hidratação."),
            Product(id = 6, title = "Cerveja", price = BigDecimal(8.99), image = R.drawable.cerveja, type = ProductTypesEnum.DRINK, description = "A cerveja é uma bebida alcoólica fermentada feita a partir de grãos de cereais, principalmente cevada, lúpulo, água e levedura. Geralmente, tem uma cor variando do amarelo ao marrom, e o seu sabor pode ser amargo ou doce, dependendo do tipo de lúpulo e malte utilizados. É uma das bebidas alcoólicas mais populares e consumidas globalmente."),
            Product(id = 7, title = "Milk Shake", price = BigDecimal(12.99), image = R.drawable.milkshake, type = ProductTypesEnum.DRINK, description = "Um milkshake é uma bebida cremosa e gelada feita tradicionalmente com sorvete e leite, podendo também incluir xaropes de sabor, como chocolate, morango ou baunilha. É frequentemente misturado em um liquidificador até ficar homogêneo e servido com chantilly ou outros toppings. É uma opção popular de sobremesa ou refresco em diversas partes do mundo.", inPromo = true),
            Product(id = 8, title = "Café", price = BigDecimal(4.99), image = R.drawable.cafe, type = ProductTypesEnum.DRINK),
            Product(id = 9, title = "Brigadeiro", price = BigDecimal(3.99), image = R.drawable.brigadeiro, type = ProductTypesEnum.SWEET, inPromo = true),
            Product(id = 10, title = "Pudim", price = BigDecimal(8.99), image = R.drawable.pudim, type = ProductTypesEnum.SWEET, description = "O pudim é uma sobremesa cremosa e suave, feita tradicionalmente com uma mistura de leite, ovos, açúcar e essência de baunilha. A mistura é cozida em banho-maria até firmar, resultando em uma textura delicada. Após esfriar, é desenformado, muitas vezes com uma camada de calda de caramelo que adiciona um sabor doce e rico. O pudim é uma sobremesa clássica apreciada por sua simplicidade e sabor reconfortante."),
            Product(id = 11, title = "Esfirra", price = BigDecimal(6.99), image = R.drawable.esfirra, type = ProductTypesEnum.FOOD, description = "A esfirra é um tipo de salgado de origem árabe, semelhante a uma pequena pizza fechada. É feita com uma massa fermentada que pode ser recheada com uma variedade de ingredientes, como carne moída temperada, queijo, frango desfiado, zaatar (mistura de especiarias), entre outros. Após o recheio, a esfirra é assada até que a massa fique dourada e crocante por fora, enquanto o recheio fica suculento por dentro. É uma iguaria popular em muitos países do Oriente Médio e também em outras partes do mundo."),
            Product(id = 12, title = "Cachorro Quente", price = BigDecimal(8.99), image = R.drawable.hotdog, type = ProductTypesEnum.FOOD),
            Product(id = 13, title = "Pastel", price = BigDecimal(11.99), image = R.drawable.pastel, type = ProductTypesEnum.FOOD, inPromo = true),
            Product(id = 14, title = "Bolo", price = BigDecimal(11.99), image = R.drawable.bolo, type = ProductTypesEnum.SWEET, inPromo = true),
            Product(id = 15, title = "Torta", price = BigDecimal(11.99), image = R.drawable.torta, type = ProductTypesEnum.SWEET, description = "Uma torta doce é uma sobremesa de origem culinária que consiste em uma base de massa, que pode ser feita de diferentes tipos, como massa quebrada, massa folhada ou massa de biscoito, e recheada com uma variedade de ingredientes doces, como frutas frescas, cremes, geleias, chocolate, creme de confeiteiro, entre outros. Pode ser servida fria ou quente, e muitas vezes é decorada com coberturas adicionais, como chantilly, frutas frescas, ou uma cobertura de glacê. As tortas doces oferecem uma grande diversidade de sabores e apresentações, sendo uma opção versátil para diversas ocasiões.")

        )
    }
}