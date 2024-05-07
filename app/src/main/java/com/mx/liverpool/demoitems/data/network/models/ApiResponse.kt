package com.mx.liverpool.demoitems.data.network.models

data class ApiResponse(
    val status: Status,
    val pageType: String,
    val plpResults: PLPResults
)

data class Status(
    val status: String,
    val statusCode: Int
)

data class PLPResults(
    val sortOptions: List<SortOption>,
    val refinementGroups: List<RefinementGroup>,
    val records: List<ProductRecord>,
    val refinement: List<Refinement>,
    val navigation: Navigation,
    val customUrlParam: Map<String, Any>,
    val metaData: Map<String, Any>,
    val productRecord: List<ProductRecord>
)

data class SortOption(
    val sortBy: String,
    val label: String
)

data class RefinementGroup(
    val name: String,
    val refinement: List<Refinement>
)

data class Refinement(
    val count: Double,
    val label: String,
    val refinementId: String,
    val selected: Boolean,
    val type: String,
    val searchName: String
)

data class Navigation(
    val ancester: List<Any>,
    val current: List<Category>,
    val childs: List<Any>
)

data class Category(
    val label: String,
    val categoryId: String
)

data class ProductRecord(
    val productId: String,
    val skuRepositoryId: String,
    val productDisplayName: String,
    val productType: String,
    val productRatingCount: Int,
    val productAvgRating: Double,
    val promotionalGiftMessage: String,
    val listPrice: Double,
    val minimumListPrice: Double,
    val maximumListPrice: Double,
    val promoPrice: Double,
    val minimumPromoPrice: Double,
    val maximumPromoPrice: Double,
    val isHybrid: Boolean,
    val isMarketPlace: Boolean,
    val isImportationProduct: Boolean,
    val brand: String,
    val seller: String,
    val category: String,
    val dwPromotionInfo: DwPromotionInfo,
    val isExpressFavoriteStore: Boolean,
    val isExpressNearByStore: Boolean,
    val smImage: String,
    val lgImage: String,
    val xlImage: String,
    val groupType: String,
    val plpFlags: List<String>,
    val variantsColor: List<VariantsColor>
)

data class DwPromotionInfo(
    val dwToolTipInfo: String,
    val dWPromoDescription: String
)

data class VariantsColor(
    val colorName: String,
    val colorHex: String,
    val colorImageURL: String,
    val colorMainURL: String?,
    val skuId: String?
)

