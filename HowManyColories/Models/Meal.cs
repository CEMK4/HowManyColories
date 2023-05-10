using HowManyColories.Areas.Identity.Data;

namespace HowManyColories.Models
{
    public class Meal
    {
        public int Id { get; set; }        
        public DateTime MealTime { get; set; }
              
        public virtual ICollection<Product> Products { get; set; }

        public virtual User User { get; set; }
    }
}
