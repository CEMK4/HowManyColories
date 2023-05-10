namespace HowManyColories.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string? Description { get; set; }
        public int? Calories { get; set; }
        public int? Carbs { get; set; }
        public int? Proteins { get; set; }
        public int? Fats { get; set; }

        public virtual ICollection<Meal> Meals { get; set; }
    }
}
