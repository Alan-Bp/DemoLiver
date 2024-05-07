import com.mx.liverpool.demoitems.data.network.models.ProductRecord

data class ProductLiver(
    val title: String,
    val normalPrice: Double,
    val discountPrice: Double,
    val imageUrl: String,
    val availabilityColors: List<ColorVariant>,

    )
data class ColorVariant(
    val colorName: String,
    val colorHex: String,
    val colorImageURL: String?
)
fun mapProductRecordToProductLiver(record: ProductRecord): ProductLiver {
    val colorVariants = record.variantsColor.map { variant ->
        ColorVariant(
            colorName = variant.colorName,
            colorHex = variant.colorHex,
            colorImageURL = variant.colorImageURL
        )
    }

    return ProductLiver(
        title = record.productDisplayName,
        normalPrice = record.listPrice,
        discountPrice = record.promoPrice,
        imageUrl = record.smImage,
        availabilityColors = colorVariants
    )
}
