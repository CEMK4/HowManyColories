using Microsoft.AspNetCore.Mvc.ModelBinding;
using System.ComponentModel.DataAnnotations;

namespace HowManyColories.Models
{
    public class Product
    {
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Title { get; set; }

        [StringLength(100)]
        public string? Description { get; set; }

        [Range(0, 2000)]
        public int? Calories { get; set; }

        [Range(0, 100)]
        public int? Carbs { get; set; }

        [Range(0, 100)]
        public int? Proteins { get; set; }

        [Range(0, 100)]
        public int? Fats { get; set; }

        public virtual ICollection<Meal>? Meals { get; set; }
    }
}
